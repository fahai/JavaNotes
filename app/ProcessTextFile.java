package org.fahai.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**   
 * @Title: ProcessTextFile.java 
 * @Package org.fahai.app 
 * @Description: ��ĳ��Ŀ¼����������ı��ļ���ͬ�����ı�����
 * @author fahai  
 * @date 2014-7-21 ����03:39:01 
 * @version V1.0   
 */
public class ProcessTextFile {
	
	// ȡϵͳ�̷�
	static String sep = File.separator;
	String filename = "D:\\user\\449631\\����\\eclipse key.txt";
	String insertLine = "Write by fahai";
	
	/**
	 * ����һ���ļ��Ĳ���
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

