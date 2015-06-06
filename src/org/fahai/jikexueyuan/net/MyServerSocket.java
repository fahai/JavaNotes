package org.fahai.jikexueyuan.net;

import org.fahai.common.LogInterface;

public class MyServerSocket implements LogInterface{

	public static void main(String[] args) {
		new ServerListener().start();
	}

}
