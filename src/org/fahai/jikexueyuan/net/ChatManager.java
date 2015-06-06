package org.fahai.jikexueyuan.net;

import java.util.Vector;

public class ChatManager {
	
	private static final ChatManager cm = new ChatManager();
	
	private ChatManager(){
		
	}
	
	public static ChatManager getChatManager(){
		return cm;
	}
	
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket cs){
		vector.add(cs);
	}
	
	public void publish(ChatSocket cs, String msg){
			for(int i=0; i<vector.size(); i++){
				ChatSocket chat = vector.get(i);
				if(!cs.equals(chat)){
					chat.out(msg);
				}
			}
	}

}
