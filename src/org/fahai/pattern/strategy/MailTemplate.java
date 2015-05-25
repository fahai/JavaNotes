package org.fahai.pattern.strategy;

/**   
 * @Title: MailTemplate.java 
 * @Package org.fahai.pattern.strategy 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-28 吮爬11:21:37 
 * @version V1.0   
 */
public abstract class MailTemplate {
	
	private String from;
	private String to;
	private String subject;
	private String context;
	
	public MailTemplate(String _from, String _to, String _subject, String _context){
		this.from = _from;
		this.to = _to;
		this.subject = _subject;
		this.context = _context;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
	
}

