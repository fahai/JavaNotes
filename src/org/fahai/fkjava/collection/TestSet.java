/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.collection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 20, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * 
 * @author 449631
 * @since 1.0
 */
public class TestSet {

	private static Logger logger = Logger.getLogger(TestSet.class);

	/**
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		TestSet test = new TestSet();
		test.testEnumSet();
	}

	public void testSet() {
		Set books = new HashSet();
		// 如果两个对象的equals()方法返回ture，则Set认为这两个对象就是一个对象
		books.add(new String("Thinking in Java"));
		books.add(new String("Thinking in Java"));
		books.add("Thinking in Java");
		// 集合元素可以是null
		books.add(null);
		logger.info(books.toString());
	}

	/*
	 * 在HashSet看来， 如果两个对象hashCode()和equals()都相等，才认为是一个对象
	 */
	public void testHashSet() {
		Set books = new HashSet();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		books.add(new C());
		books.add(new C());
		logger.info(books);
	}
	
	/**
	 * 会记录顺序的HashSet 
	 * void
	 */
	public void testLinkedHashSet(){
		Set books = new LinkedHashSet();
		books.add("Thinking in Java");
		books.add("Effective Java");
		books.add("JVM");
 		logger.info(books);
		books.remove("Thinking in Java");
		books.add("Thinking in Java");
		logger.info(books);
	}
	
	public void testTreeSet(){
		TreeSet nums = new TreeSet();
		nums.add(5);
		nums.add(3);
		nums.add(6);
		nums.add(1);
		nums.add(2);
		nums.add(4);
		// 添加的元素需实现Comparable接口，否则会引发java.lang.ClassCastException
		// 只有一个元素，则可以无需实现Comparable接口
//		 nums.add(new A());
		
		// 添加元素时，会调用compareTo(Object obj)方法判断元素大小
		// 如果与其它元素类型不一样会引发java.lang.ClassCastException
		// 如果重写了该元素的compareTo()方法，则另当别论
//		nums.add("Thinking in Java");
		
		logger.info(nums);
		// 顺序与添加元素的顺序无关
		logger.info("first element: " + nums.first());
		logger.info("last element: " + nums.last());
	}
	
	public void testEnumSet(){
		EnumSet enumSet = EnumSet.allOf(Season.class);
		logger.info("enumSet: " + enumSet);
		EnumSet enumSet2 = EnumSet.noneOf(Season.class);
		logger.info("emptyEnum: " + enumSet2);
		enumSet2.add(Season.SPRING);
		enumSet2.add(Season.SUMMER);
		logger.info("enumSet2: " + enumSet2);
		
		// 以指定枚举值创建EnumSet集合
		EnumSet enumSet3 = EnumSet.of(Season.SUMMER, Season.WINTER);
		logger.info("enumSet3: " + enumSet3);
		
		// 以已知枚举对象的范围创建EnumSet对象
		EnumSet enumSet4 = EnumSet.range(Season.SUMMER, Season.WINTER);
		logger.info("enumSet4: " + enumSet4);
		
		// 以已知枚举对象的补集创建EnumSet对象
		EnumSet enumSet5 = EnumSet.complementOf(enumSet4);
		logger.info("enumSet5: " + enumSet5);
	}

}

class A {
	public boolean equals(Object obj) {
		return true;
	}
}

class B {
	public int hashCode() {
		return 1;
	}
}

class C {

	public int hashCode() {
		return 2;
	}

	public boolean equals(Object obj) {
		return true;
	}

}

enum Season{
	SPRING, SUMMER, FALL, WINTER
}
