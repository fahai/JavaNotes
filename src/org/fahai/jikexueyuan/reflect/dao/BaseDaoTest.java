package org.fahai.jikexueyuan.reflect.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BaseDaoTest {
	
	private static Logger logger = Logger.getLogger(BaseDaoTest.class);

	@Test
	public void testList() {
		ArrayList result = BaseDao.list(Employee.class);
		for(Object e : result){
			logger.info(e);
		}
	}

	@Test
	public void testGetById() {
		ArrayList result = BaseDao.list(Employee.class);
		for(Object e : result){
			logger.info(e);
		}
	}

	@Test
	public void testGetBy() {
		ArrayList employees = BaseDao.getBy(Employee.class, "name", "fahai");
		for(Object e : employees){
			logger.info(e);
		}
	}
	
	@Test
	public void testSave(){
//		Employee e = new Employee();
//		e.setName("God");
//		e.setDuty("CTO");
//		e.setDeptId(999);
//		Integer successNum = BaseDao.save(e);
//		logger.info("insert success: " + successNum);
		
		Department d = new Department();
		d.setName("养老");
		Integer successNum = BaseDao.save(d);
		logger.info("insert success: " + successNum);
	}
	
	@Test
	public void testUpdate(){
		Employee e = new Employee();
		e.setId(1);
		e.setName("fahai");
		e.setDuty("CEO");
		e.setDeptId(2);
		Integer num = BaseDao.update(e);
		logger.info("update success: " + num);
	}
	
	@Test
	public void testDelete(){
		Integer num = BaseDao.delete(Employee.class, 890);
		logger.info("delete success: " + num);
	}

}
