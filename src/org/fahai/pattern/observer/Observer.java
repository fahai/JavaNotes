package org.fahai.pattern.observer;

import org.fahai.common.LogInterface;

/**
 * Observer Pattern - 观察者模式
 * 当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化
 * 对象之间是一对多的关系
 * 
 * TODO 这不是观察，只是等待通知
 * @author fahai
 *
 */
public interface Observer extends LogInterface {
	
	public void update();

}
