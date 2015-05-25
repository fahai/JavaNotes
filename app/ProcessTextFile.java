package org.fahai.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**   
 * @Title: ProcessTextFile.java 
 * @Package org.fahai.app 
 * @Description: 对某个目录下面的所有文本文件做同样的文本处理
 * @author fahai  
 * @date 2014-7-21 下午03:39:01 
 * @version V1.0   
 */
public class ProcessTextFile {
	
	// 取系统盘符
	static String sep = File.separator;
	String filename = "D:\\user\\449631\\桌面\\eclipse key.txt";
	String insertLine = "Write by fahai";
	
	/**
	 * 处理一个文件的操作
	 * @param filename
	 * @return
	 */
	private int process(String filename){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			bw.write(insertLine);
			bw.newLine();
			bw.flush();
			bw.close();
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessTextFile pf = new ProcessTextFile();
		System.out.println(pf.process(pf.filename));
		
//		for (String arg : args){
//			System.out.println(arg);
//		}
		System.out.println(args[1]);
	}

}

