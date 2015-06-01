package org.fahai.jikexueyuan.reflect.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 升级版的BaseDao
 * 获取表的所有列名，并与bean对象的属性做校验
 * 拼接SQL的时候，以获取的列名为准
 * like语句不支持占位符
 * @author fahai
 *
 */
public class BaseDaoUpdate {
	
	/**
	 * 根据DatabaseMetaData对象可获取单表列名以及列的所有属性
	 * 该方法只获取列名
	 * @param tableName
	 * @return
	 */
	public ArrayList<String> getAllColumns(String tableName){
		ArrayList<String> columns = new ArrayList<String>();
		Connection conn = BaseConnection.getConnection();
		ResultSet rs = null;
		try {
			DatabaseMetaData dd = conn.getMetaData();
			rs = dd.getColumns(null, "%", tableName, "%");
			while(rs.next()){
				columns.add(rs.getString("COLUMN_NAME"));
//				rs.getString("TYPE_NAME"); 列的数据类型
//				rs.getInt("COLUMN_SIZE"); 列的长度
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columns;
	}
	
	/**
	 * 获取数据表的列名，根据列名来指定列查询表数据，理论上速度会快一点
	 * @param clazz
	 * @return
	 * ArrayList
	 */
	public ArrayList list(Class clazz){
		ArrayList result = new ArrayList();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		ArrayList<String> columns = getAllColumns(clazz.getSimpleName());
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for(int i=0; i<columns.size(); i++){
			sb.append(columns.get(i));
			if(i != columns.size()-1){
				sb.append(", ");
			}
		}
		sb.append(" from " + clazz.getSimpleName());
		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for(Field field : fields){
					field.setAccessible(true);
					if(columns.contains(field.getName())){
						field.set(obj, rs.getObject(field.getName()));
					}
				}
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return result;
	}
	
	public Object getById(Class clazz, Integer id){
		//TODO 根据主键的值来查询
		Object obj = new Object();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		ArrayList<String> columns = getAllColumns(clazz.getSimpleName());
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for(int i=0; i<columns.size(); i++){
			sb.append(columns.get(i));
			if(i != columns.size()-1){
				sb.append(", ");
			}
		}
		sb.append(" from " + clazz.getSimpleName());
		sb.append(" where " + fields[0].getName() + " = " + id);
		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				obj = clazz.newInstance();
				for(Field field : fields){
					field.setAccessible(true);
					if(columns.contains(field.getName())){
						field.set(obj, rs.getObject(field.getName()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public ArrayList getBy(Class clazz, String condition, String value){
		//TODO 根据某一列的值来查询
		return null;
	}
	
	public Integer save(Object obj){
		//TODO 升级版的插入记录，并返回主键值
		return 0;
	}
	
	public Integer update(Object obj){
		//TODO 升级版的跟新记录
		return 0;
	}
	
	public Integer delete(Class calzz, Integer id){
		//TODO 升级版的删除记录
		return 0;
	}

}
