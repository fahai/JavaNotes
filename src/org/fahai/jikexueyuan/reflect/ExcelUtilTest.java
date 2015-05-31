package org.fahai.jikexueyuan.reflect;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ExcelUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExportExcel() {
		ExcelUtil util = new ExcelUtil();
		Book book1 = new Book(111, "Thinking in Java", "IT");
		Book book2 = new Book(222, "Effective Java", "Java");
		Book book3 = new Book(333, "Spring IOC", "IT");
		ArrayList data = new ArrayList();
		data.add(book1);
		data.add(book2);
		data.add(book3);
		util.exportExcel(data, "./book.xls");
	}
	
	@Test
	public void testImportExcel(){
		ExcelUtil util = new ExcelUtil();
		ArrayList books = util.importExcel(Book.class, "./book.xls");
		for(Object book : books){
			System.out.println(((Book) book).getName());
		}
	}

}
