package org.fahai.pattern.strategy;

/**   
 * @Title: Client.java 
 * @Package org.fahai.pattern.strategy 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-28 吮爬11:49:24 
 * @version V1.0   
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MailTemplate textmail = new TextMail("text@from.com", "text@to.com", "text subject", "text context");
		MailServer server = new MailServer(textmail);
		server.sendMail();
		
		MailTemplate htmlmail = new HtmlMail("html@from.com", "html@to.com", "html's subject", "html's context");
		server = new MailServer(htmlmail);
		server.sendMail();
	}

}

