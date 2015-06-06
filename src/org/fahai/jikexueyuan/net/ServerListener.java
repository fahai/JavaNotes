package org.fahai.jikexueyuan.net;

import java.net.ServerSocket;
import java.net.Socket;

import org.fahai.common.LogInterface;

public class ServerListener extends Thread implements LogInterface{
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(12345);
			while (true) {
				// block
				Socket socket = server.accept();
				log.info("accept the request of client...");
				// 把socket传递给新的线程
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
