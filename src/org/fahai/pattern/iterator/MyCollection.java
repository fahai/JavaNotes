package org.fahai.pattern.iterator;


/**
 * Iterator Pattern - 迭代器模式
 * 顺序访问聚集中的对象
 * 聚集对象 and 迭代器对象
 * @author fahai
 *
 */
public class MyCollection implements Collection {
	
	private String[] strs = {"A", "B", "C", "D", "E"};

	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return strs[i];
	}

	@Override
	public int size() {
		return strs.length;
	}

}
