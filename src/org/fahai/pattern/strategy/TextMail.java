package org.fahai.pattern.strategy;

/**   
 * @Title: TextMail.java 
 * @Package org.fahai.pattern.strategy 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-28 吮爬11:27:04 
 * @version V1.0   
 */
public class TextMail extends MailTemplate {
	
	public TextMail(String _from, String _to, String _subject, String _context){
		super(_from, _to, _subject, _context);
	}
	
	@Override
	public String getContext(){
		String context = "\nContent_Type: text/plain; charset=GB2312\n" + super.getContext();
		context = context + "\nThe mail format: BASE64";
		return context;
	}

}

