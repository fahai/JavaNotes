package org.fahai.jikexueyuan.reflect.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 万能DAO
 * @author fahai
 *
 */
public class BaseDao {
	
	/**
	 * 使用反射，查询指定对象的所有记录
	 * 拼接查询的SQL语句
	 * 利用反射，获取属性值，并调用set方法赋值(setter和getter方法必须要存在)
	 * @param clazz
	 * @return
	 */
	public static ArrayList list(Class clazz){
		ArrayList result = new ArrayList();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(clazz.getSimpleName());
		Field[] fields = clazz.getDeclaredFields();
		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for(Field field : fields){
					field.setAccessible(true);
					field.set(obj, rs.getObject(field.getName()));
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
	 * 根据主键查询记录
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static Object getById(Class clazz, Integer id){
		Object result = null;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(clazz.getSimpleName());
		// 要求表的主键对应的bean属性放在第一的位置
		sb.append(" where " + fields[0].getName() + " = " + id);
		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				result = clazz.newInstance();
				for(Field field : fields){
					field.setAccessible(true);
					field.set(result, rs.getObject(field.getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return result;
	}
	
	/**
	 * 根据给出属性和值来查询记录
	 * bean对象中的属性需与表中的列名一致
	 * 只支持字符串类型的列
	 * @param clazz
	 * @param condition
	 * @param value
	 * @return
	 */
	public static ArrayList getBy(Class clazz, String condition, String value){
		ArrayList result = new ArrayList();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from " + clazz.getSimpleName());
		sb.append(" where " + condition + " = ? ");
		try {
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, value);
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for(Field field : fields){
					field.setAccessible(true);
					field.set(obj, rs.getObject(field.getName()));
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
	 * 万能保存方法
	 * @param obj
	 * @return
	 */
	public static Integer save(Object obj){
		Integer result = 0;
		Class clazz = obj.getClass();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("insert into " + clazz.getSimpleName());
		sb.append(" ( ");
		for(int i=1; i<fields.length; i++){
			sb.append(fields[i].getName());
			if(i != fields.length-1){
				sb.append(", ");
			}
		}
		sb.append(" ) values ( ");
		for(int i=1; i<fields.length; i++){
			sb.append("? ");
			if(i != fields.length-1){
				sb.append(", ");
			}
		}
		sb.append(") ");
//		System.out.println(sb.toString());
		try {
			ps = conn.prepareStatement(sb.toString());
			for(int i =1; i<fields.length; i++){
				fields[i].setAccessible(true);
				if(fields[i].getType().toString().equals("class java.lang.String")){
					ps.setString(i, fields[i].get(obj).toString());
				}else if(fields[i].getType().toString().equals("int")){
					ps.setInt(i, fields[i].getInt(obj));
				}else{
					System.out.println("unsupport data type!");
				}
			}
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps);
		}
		return result;
	}
	
	/**
	 * 万能修改方法
	 * 根据obj的主键来更新记录
	 * @param obj
	 * @return
	 */
	public static Integer update(Object obj){
		Integer result = 0;
		Class clazz = obj.getClass();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		// UPDATE employee t SET name = 'fahai' where id = 1
		sb.append("update " + clazz.getSimpleName() + " set ");
		for(int i=1; i<fields.length; i++){
			fields[i].setAccessible(true);
			sb.append(fields[i].getName() + " = ?");
			if(i != fields.length-1){
				sb.append(", ");
			}
		}
		fields[0].setAccessible(true);
		sb.append(" where " + fields[0].getName() + " = ? ");
		try {
			ps = conn.prepareStatement(sb.toString());
			for(int i=1; i<fields.length; i++){
				fields[i].setAccessible(true);
				if(fields[i].getType().toString().equals("class java.lang.String")){
					ps.setString(i, fields[i].get(obj).toString());
				}else if(fields[i].getType().toString().equals("int")){
					ps.setInt(i, fields[i].getInt(obj));
				}else{
					System.out.println("update: unsupport data type!");
				}
			}
			fields[0].setAccessible(true);
			ps.setInt(fields.length, fields[0].getInt(obj));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Integer delete(Class clazz, Integer id){
		Integer result = 0;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("delete from " + clazz.getSimpleName());
		fields[0].setAccessible(true);
		sb.append(" where " + fields[0].getName() + " = ?");
		try {
			ps = conn.prepareStatement(sb.toString());
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
