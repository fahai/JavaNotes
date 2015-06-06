package org.fahai.jikexueyuan.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	
	Socket socket;
	
	public ChatSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void out(String msg){
		try {
			socket.getOutputStream().write(msg.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(), "UTF-8"));
			String line;
			while((line=br.readLine()) != null){
				ChatManager.getChatManager().publish(this, line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
