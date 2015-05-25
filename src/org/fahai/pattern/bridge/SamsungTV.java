package org.fahai.pattern.bridge;

import org.apache.log4j.Logger;

/**   
 * @Title: SamsungTV.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29 芟爬02:38:49 
 * @version V1.0   
 */
public class SamsungTV implements ITV {
	
	private static Logger log = Logger.getLogger(SamsungTV.class);

	@Override
	public void on() {
		// TODO Auto-generated method stub
		log.info("Sansung TV is on.");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		log.info("Sansung TV is off.");
	}

	@Override
	public void switchChannel(int channel) {
		// TODO Auto-generated method stub
		log.info("Sansung: channel is switch to " + channel);
	}

}

