package org.fahai.pattern.prototype;

/**   
 * @Title: Mail.java 
 * @Package org.fahai.pattern.prototype 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-30 芟爬05:57:17 
 * @version V1.0   
 */
public class Mail {
	
	private String receiver;
	private String subject;
	private String nickname;
	private String context;
	private String tail;
	
	public Mail(AdvTemplate adv){
		this.subject = adv.getAdvSubject();
		this.context = adv.getAdvContext();
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	

}

