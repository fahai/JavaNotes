package org.fahai.jikexueyuan.reflect.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DaoTest {
	
	private static Logger logger = Logger.getLogger(DaoTest.class);

	public static void main(String[] args) {
		EmployeeDao ed = new EmployeeDao();
//		ArrayList<Employee> employees = ed.list();
//		for(Employee e : employees){
//			logger.info(e);
//		}
		
		ArrayList employees = BaseDao.list(Employee.class);
		for(Object e : employees){
			logger.info(e);
		}
		
		Object employee = BaseDao.getById(Employee.class, 1);
		logger.info(employee);
	}

}
