package org.fahai.pattern.visitor;

import org.fahai.common.LogInterface;

/**
 * Visitor Pattern - 访问者模式
 * 解耦对象数据结构和行为
 * 达到被访问者可以添加新的操作而无需做其他的修改
 * @author fahai
 *
 */
public interface Visitor extends LogInterface{
	
	public void visit(Subject subject);

}
