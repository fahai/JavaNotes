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
 * @Description: 打印匹配项所在的行
 * @author A18ccms A18ccms_gmail_com   
 * @date 2014-7-21 下午03:28:24 
 * @version V1.0   
 */
public class PrintMapping {
	
	/**
	 * 从一个目录读取文件名
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
	 * 把文件内容读取到List对象
	 * @param filename
	 * @return
	 */
	public List<String> filetoList(String filename) {
		List<String> result = new ArrayList<String>();
		// 创建一个字符读取注和一个字符冲区进行关联
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// 因为如何readLine()读取到了文件末尾，返回一个null，我们可以采用下面的方法
			String line = null;
			// 因为每次调用readLine()都会返回一行数据，如果返回了一个空，条件则不满足，就退出循环了
			while ((line = buff.readLine()) != null) {
				result.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 在文件中匹配字符串，并把匹配的所在行存进List对象
	 * @param filename 文件名
	 * @param target	需要匹配的字符串
	 * @return
	 */
	public List<String> getMappingList(String filename, String target) {
		List<String> result = new ArrayList<String>();
		// 创建一个字符读取注和一个字符冲区进行关联
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// 因为如何readLine()读取到了文件末尾，返回一个null，我们可以采用下面的方法
			String line = null;
			// 因为每次调用readLine()都会返回一行数据，如果返回了一个空，条件则不满足，就退出循环了
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
	 * 在一系列的文件中匹配字符串，并把匹配的字符串存进List对象
	 * @param srcfiles 文件名列表
	 * @param target	需要匹配的字符串
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
	 * 在给定目录里面的所有文件匹配字符串
	 * @param directory	目录名
	 * @param targetfile	保存需要匹配字符串的文件，一行为一个匹配项
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
