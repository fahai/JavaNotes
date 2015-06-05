package org.fahai.pattern.bridge;

/**   
 * @Title: Human.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29
 * @version V1.0   
 */
public class Human {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ITV tv = new SamsungTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.setChannel(99);
		System.out.println("----- -----");
		lrc.setChannelKeyboard(100);
		
		ITV sony = new SonyTV();
		lrc.setTv(sony);
		lrc.setChannel(55);
	}

}

