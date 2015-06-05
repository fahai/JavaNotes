package org.fahai.pattern.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * 描述： Flyweight Pattern - 享元模式
 * 实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用
 * @author 449631
 * @since 1.0
 */
public class ConnectionPool {
	
	private Vector<Connection> pool;
	private int poolSize = 30;
	private Connection conn = null;
	
	private ConnectionPool(){
		pool = new Vector<Connection>(poolSize);
		String url = "jdbc:mysql://localhost:3306/JavaNotes";
		String username = "root";
		String password = "toor";
		try {
			for (int i = 0; i < poolSize; i++) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void release(){
		pool.add(conn);
	}
	
	public synchronized Connection getConnection(){
		if(pool.size() > 0){
			conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}else{
			return null;
		}
	}
	
}
