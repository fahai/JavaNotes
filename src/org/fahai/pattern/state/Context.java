package org.fahai.pattern.state;

import org.fahai.common.LogInterface;

/**
 * State Pattern - 状态模式
 * 当对象的状态改变时，同时改变其行为
 * 应用：网站简单的权限控制
 * @author fahai
 *
 */
public class Context implements LogInterface{
	
	private State state;
	
	protected State getState() {
		return state;
	}

	protected void setState(State state) {
		this.state = state;
	}

	public Context(State state){
		this.state = state;
	}
	
	public void method(){
		if(state.getValue().equals("state1")){
			state.method1();
		}else if(state.getValue().equals("state2")){
			state.method2();
		}else{
			log.info("unkown state!");
		}
	}

}
