package org.fahai.jikexueyuan.reflect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao {
	
	public ArrayList<Employee> list(){
		ArrayList<Employee> result = new ArrayList<Employee>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDuty(rs.getString("duty"));
				e.setDeptId(rs.getInt("deptId"));
				result.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
