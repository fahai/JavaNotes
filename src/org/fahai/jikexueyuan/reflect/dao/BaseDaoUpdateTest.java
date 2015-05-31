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

}
