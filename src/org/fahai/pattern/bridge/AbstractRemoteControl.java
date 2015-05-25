package org.fahai.pattern.bridge;

/**   
 * @Title: AbstractRemoteControl.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29 芟爬02:44:32 
 * @version V1.0   
 */
public abstract class AbstractRemoteControl {
	
	private ITV tv;
	
	public AbstractRemoteControl(ITV tv){
		this.tv = tv;
	}
	
	public void turnOn(){
		tv.on();
	}
	
	public void turnOff(){
		tv.off();
	}
	
	public void setChannel(int channel){
		tv.switchChannel(channel);
	}
	
}

