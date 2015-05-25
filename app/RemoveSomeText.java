package org.fahai.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: RemoveSomeText.java
 * @Package org.fahai.app
 * @Description: TODO
 * @author fahai
 * @date 2014-8-5 下午04:14:36
 * @version V1.0
 */
public class RemoveSomeText {
	
	public static String addSpace(String s){
		char[] str1 = s.toCharArray();
		String str2 = " ";
		int i;
		for(i = 0 ; i < s.length(); i++){
			if (Character.isDigit(str1[i]))
				str2 = str2 + str1[i];	
			else
				str2 = str2 + " " + str1[i];
		}
		return str2;
	}

	public void readFromFile(String filename, List<String> stard) {
		String[] tmp;
		// 创建一个字符读取注和一个字符冲区进行关联
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// 因为如何readLine()读取到了文件末尾，返回一个null，我们可以采用下面的方法
			String line = null;
			// 因为每次调用readLine()都会返回一行数据，如果返回了一个空，条件则不满足，就退出循环了
			while ((line = buff.readLine()) != null) {
				tmp = line.split(",");
				if (tmp.length >=8) 
					System.out.println(tmp[0] + "," + tmp[1] + "," + addSpace(tmp[8]));
				else if (tmp.length >=2)
					System.out.println(tmp[0] + "," + tmp[1]);
				else
					System.out.println(tmp[0]);
//				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comming");
		List<String> stard = new ArrayList<String>();
		List<String> uncode = new ArrayList<String>();
		RemoveSomeText pm = new RemoveSomeText();
		String filename = "d:\\user\\449631\\桌面\\btob20140805-2.log";
		String unfileName = "d:\\user\\449631\\桌面\\IVR_Done\\IVR-HK_V3.0\\incode.txt";
		pm.readFromFile(filename, stard);
		// for(String tmp : stard){
		// System.out.println(tmp);
		// }
		pm.readFromFile(unfileName, uncode);
		for (String tmp : uncode) {
			for (String tmp2 : stard) {
				if (tmp2.indexOf(tmp) >= 0) {
					System.out.println("tmp2:\t" + tmp2);
				}
			}
		}
	}

}
