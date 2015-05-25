package org.fahai.pattern.strategy;

import org.apache.log4j.Logger;

/**   
 * @Title: MailServer.java 
 * @Package org.fahai.pattern.strategy 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-28 吮爬11:42:29 
 * @version V1.0   
 */
public class MailServer {
	
	public static Logger log = Logger.getLogger(MailServer.class);
	
	private MailTemplate m;
	
	public MailServer(MailTemplate _m){
		this.m = _m;
	}

	public void sendMail(){
		log.info("----- Sending Mail -----");
		log.info("From: " + m.getFrom());
		log.info("To: " + m.getTo());
		log.info("Subject: " + m.getSubject());
		log.info("Context: " + m.getContext());
	}

}

