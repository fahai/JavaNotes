package org.fahai.pattern.bridge;

import org.apache.log4j.Logger;

/**   
 * @Title: LogitechRemoteControl.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29 芟爬02:49:00 
 * @version V1.0   
 */
public class LogitechRemoteControl extends AbstractRemoteControl {

	private static Logger log = Logger.getLogger(LogitechRemoteControl.class);
	
	public LogitechRemoteControl(ITV tv) {
		super(tv);
		// TODO Auto-generated constructor stub
	}
	
	public void setChannelKeyboard(int channel){
		setChannel(channel);
		log.info("Logitech use keyword to set channel.");
	}

}

