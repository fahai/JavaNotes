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
 * @date 2014-8-5 ����04:14:36
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
		// ����һ���ַ���ȡע��һ���ַ��������й���
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader buff = new BufferedReader(fr);
			// ��Ϊ���readLine()��ȡ�����ļ�ĩβ������һ��null�����ǿ��Բ�������ķ���
			String line = null;
			// ��Ϊÿ�ε���readLine()���᷵��һ�����ݣ����������һ���գ����������㣬���˳�ѭ����
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
		String filename = "d:\\user\\449631\\����\\btob20140805-2.log";
		String unfileName = "d:\\user\\449631\\����\\IVR_Done\\IVR-HK_V3.0\\incode.txt";
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
