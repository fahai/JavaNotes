package org.fahai.app.lunch.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.fahai.app.lunch.Lunch;
import org.fahai.app.lunch.bean.Meal;
import org.fahai.app.lunch.bean.Shop;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    2015年6月1日      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class LunchTest {

	private static Logger logger = Logger.getLogger(LunchTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetShopName() {
		Lunch lunch = new Lunch();
		String shop = lunch.getShopName(new File("http://www.asp.sf-express.com"));
		logger.info(shop);
	}

	@Test
	public void testGetDishNames(){
		Lunch lunch = new Lunch();
		ArrayList<Meal> meals = lunch.getDishNames(new File("http://www.asp.sf-express.com"));
		for(Meal meal : meals){
			logger.info(meal);
		}
	}
	
	@Test
	public void testExportMd(){
		Lunch lunch = new Lunch();
		File directory = new File("./others/lunch");
		ArrayList<Shop> shops = lunch.getShops(directory);
		boolean isSuccess = lunch.exportMd(shops);
		logger.info(isSuccess);
	}
}
