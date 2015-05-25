package org.fahai.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: PrintMapping.java 
 * @Package org.fahai.app 
 * @Description: ��ӡƥ�������ڵ���
 * @author A18ccms A18ccms_gmail_com   
 * @date 2014-7-21 ����03:28:24 
 * @version V1.0   
 */
public class PrintMapping {
	
	/**
	 * ��һ��Ŀ¼��ȡ�ļ���
	 * @param directory
	 * @return
	 */
	public List<String> getFilename(String directory){
		List<String> result = new ArrayList<String>();
		File files = new File(directory);
		String[] filenames = files.list();
		for(int i=0; i<filenames.length; i++){
			result.add(directory + "\\" + filenames[i]);
		}
		return result;
	}
	
	/**
	 * ���ļ����ݶ�ȡ��List����
	 * @param filename
	 * @return
	 */
	public List<String> filetoList(String filename) {
		List<String> result = new ArrayList<String>();
		// ����һ���ַ���ȡע��һ���ַ��������й���
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// ��Ϊ���readLine()��ȡ�����ļ�ĩβ������һ��null�����ǿ��Բ�������ķ���
			String line = null;
			// ��Ϊÿ�ε���readLine()���᷵��һ�����ݣ����������һ���գ����������㣬���˳�ѭ����
			while ((line = buff.readLine()) != null) {
				result.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ���ļ���ƥ���ַ���������ƥ��������д��List����
	 * @param filename �ļ���
	 * @param target	��Ҫƥ����ַ���
	 * @return
	 */
	public List<String> getMappingList(String filename, String target) {
		List<String> result = new ArrayList<String>();
		// ����һ���ַ���ȡע��һ���ַ��������й���
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// ��Ϊ���readLine()��ȡ�����ļ�ĩβ������һ��null�����ǿ��Բ�������ķ���
			String line = null;
			// ��Ϊÿ�ε���readLine()���᷵��һ�����ݣ����������һ���գ����������㣬���˳�ѭ����
			while ((line = buff.readLine()) != null) {
				if(line.indexOf(target) >= 0)
					result.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.add("\t");
		return result;
	}
	
	/**
	 * ��һϵ�е��ļ���ƥ���ַ���������ƥ����ַ������List����
	 * @param srcfiles �ļ����б�
	 * @param target	��Ҫƥ����ַ���
	 * @return
	 */
	public List<String> getMappingFromLists(List<String> srcfiles, String target){
		List<String> result = new ArrayList<String>();
		for(String srcfile : srcfiles){
			result.add("----- " + srcfile + " -----");
			List<String> tmp = new ArrayList<String>();
			tmp = getMappingList(srcfile, target);
			for(String str : tmp){
				result.add(str);
			}
		}
		return result;
	}
	
	/**
	 * �ڸ���Ŀ¼����������ļ�ƥ���ַ���
	 * @param directory	Ŀ¼��
	 * @param targetfile	������Ҫƥ���ַ������ļ���һ��Ϊһ��ƥ����
	 */
	public void printResult(String directory, String targetfile, String outputfile){
		List<String> srcfiles = getFilename(directory);
		List<String> targets = filetoList(targetfile);
		try {
			PrintStream ps = new PrintStream(new File(outputfile));
			System.setOut(ps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String target : targets){
			System.out.println("  ===== " + target + " =====");
			List<String> result = getMappingFromLists(srcfiles, "13410802579"); 
			for(String str : result){
				System.out.println(str);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		PrintMapping pm = new PrintMapping();
//		pm.printResult("D:\\temp\\src", "D:\\temp\\incode.txt");
		pm.printResult(args[0], args[1], args[2]);
	}

}
