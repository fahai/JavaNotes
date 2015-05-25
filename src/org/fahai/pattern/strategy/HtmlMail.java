package org.fahai.pattern.strategy;

/**   
 * @Title: HtmlMail.java 
 * @Package org.fahai.pattern.strategy 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-28 芟爬01:39:02 
 * @version V1.0   
 */
public class HtmlMail extends MailTemplate {

	public HtmlMail(String _from, String _to, String _subject, String _context) {
		super(_from, _to, _subject, _context);
	}
	
	@Override
	public String getContext(){
		String context = "\nContent-Type: multipart/mixed; charset=GB2312\n" + super.getContext();
		context = context + "\nThe mail format: HTML Format"; 
		return context;
	}

}

