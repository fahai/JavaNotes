package org.fahai.jikexueyuan.reflect.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.print.attribute.standard.PresentationDirection;

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
	/**
	 * 根据主键的值来查询
	 * @param clazz
	 * @param id
	 * @return
	 * Object
	 */
	public Object getById(Class clazz, Integer id){
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
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return obj;
	}
	
	/**
	 * 根据某一列的值来查询
	 * @param clazz		
	 * @param condition 列名
	 * @param value		值
	 * @return
	 * ArrayList
	 */
	public ArrayList getBy(Class clazz, String condition, String value){
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
		sb.append(" where " + condition + " = ? ");
		try {
			ps = conn.prepareStatement(sb.toString());
			ps.setObject(1, value);
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
	
	/**
	 * 升级版的插入记录，并返回主键值
	 * insert into employee (name, duty, deptId) values("fahai", "CHO", 2);
	 * @param obj
	 * @return
	 * Integer
	 */
	public Integer save(Object obj){
		int index = 0;
		Class clazz = obj.getClass();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		ArrayList<String> columns = getAllColumns(clazz.getSimpleName());
		StringBuilder sb = new StringBuilder();
		sb.append("insert into " + clazz.getSimpleName() + " ( ");
		for(int i=1; i<columns.size(); i++){
			sb.append(columns.get(i));
			if(i != columns.size()-1){
				sb.append(", ");
			}
		}
		sb.append(" ) values ( ");
		for(int i=1; i<columns.size(); i++){
			sb.append("?");
			if(i != columns.size()-1){
				sb.append(", ");
			}
		}
		sb.append(") ");
		try {
			ps = conn.prepareStatement(sb.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
			for(int i=1; i<fields.length; i++){
				fields[i].setAccessible(true);
				if(columns.contains(fields[i].getName())){
					ps.setObject(i, fields[i].get(obj));
				}
			}
			int isSuccess = ps.executeUpdate();
			if(isSuccess > 0){
				rs = ps.getGeneratedKeys();
				while(rs.next()){
					index = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return index;
	}
	
	/**
	 * 升级版的跟新记录
	 * update employee set name = "tomcat" where id = 9;
	 * @param obj
	 * @return
	 * Integer 0-失败，1-成功
	 */
	public Integer update(Object obj){
		int isSuccess = 0;
		Class clazz = obj.getClass();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> columns = getAllColumns(clazz.getSimpleName());
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("update " + clazz.getSimpleName() + " set ");
		for(int i=1; i<columns.size(); i++){
			sb.append(columns.get(i) + " = ?");
			if(i != columns.size()-1){
				sb.append(", ");
			}
		}
		sb.append(" where " + columns.get(0) + " = ?");
		System.out.println(sb.toString());
		try {
			ps = conn.prepareStatement(sb.toString());
			for(int i=1; i<fields.length; i++){
				fields[i].setAccessible(true);
				ps.setObject(i, fields[i].get(obj));
			}
			fields[0].setAccessible(true);
			ps.setObject(columns.size(), fields[0].get(obj));
			isSuccess = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return isSuccess;
	}
	
	/**
	 * 升级版的删除记录
	 * delete from employe where id > 3;
	 * @param calzz
	 * @param id
	 * @return
	 * Integer
	 */
	public Integer delete(Class clazz, Integer id){
		Integer isSuccess = 0;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from " + clazz.getSimpleName() + " where ");
		fields[0].setAccessible(true);
		sb.append(fields[0].getName() + " = ?");
		System.out.println(sb.toString());
		try {
			ps = conn.prepareStatement(sb.toString());
			ps.setInt(1, id);
			isSuccess = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps);
		}
		return isSuccess;
	}
	
	// TODO 执行指定SQL
	public Integer executeSql(Class clazz, String sql, Object[] args){
		Integer result = 0;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		return 0;
	}

}

























