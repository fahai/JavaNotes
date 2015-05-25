package org.fahai.pattern.bridge;

import org.apache.log4j.Logger;

/**   
 * @Title: SonyTV.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29 芟爬02:42:04 
 * @version V1.0   
 */
public class SonyTV implements ITV {

	private static Logger log = Logger.getLogger(SonyTV.class);
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		log.info("Sony TV is on.");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		log.info("Sony TV is off.");
	}

	@Override
	public void switchChannel(int channel) {
		// TODO Auto-generated method stub
		log.info("Sony : channel is switch to " + channel);
	}

}

