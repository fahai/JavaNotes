package org.fahai.pattern.bridge;

/**   
 * @Title: Human.java 
 * @Package org.fahai.pattern.bridge 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-29 芟爬02:51:29 
 * @version V1.0   
 */
public class Human {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITV tv = new SamsungTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.setChannel(99);
		System.out.println("----- -----");
		lrc.setChannelKeyboard(100);
	}

}

