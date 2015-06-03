package org.fahai.jikexueyuan.reflect.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BaseDaoUpdateTest {
	
	private static Logger logger = Logger.getLogger(BaseDaoUpdateTest.class);

	@Test
	public void testGetAllColumns() {
		BaseDaoUpdate bu = new BaseDaoUpdate();
		bu.getAllColumns("employee");
	}
	
	@Test
	public void testList(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		ArrayList result = bu.list(Employee.class);
		for(Object e : result){
			logger.info(e);
		}
	}
	
	@Test
	public void testGetById(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		Object obj = bu.getById(Department.class, 2);
		logger.info(obj);
	}
	
	@Test
	public void testGetBy(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		ArrayList lists = bu.getBy(Employee.class, "name", "dashi");
		for(Object e : lists){
			logger.info(e);
		}
	}
	
	@Test
	public void testSave(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		Employee tomcat = new Employee();
		tomcat.setName("tomcat");
		tomcat.setDuty("web");
		tomcat.setDeptId(1);
		int index = bu.save(tomcat);
		System.out.println(index);
	}
	
	@Test
	public void testUpdate(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		Employee tomcat = new Employee();
		tomcat.setId(1);
		tomcat.setName("tomcat");
		tomcat.setDuty("web");
		tomcat.setDeptId(1);
		int index = bu.update(tomcat);
		System.out.println(index);
	}
	
	@Test
	public void testDelete(){
		BaseDaoUpdate bu = new BaseDaoUpdate();
		int isSuccess = bu.delete(Employee.class, 9);
		System.out.println(isSuccess);
	}

}
