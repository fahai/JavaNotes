package org.fahai.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * @Title: TestFileIO.java
 * @Package org.fahai.app
 * @Description: TODO
 * @author fahai
 * @date 2014-7-22 ����03:17:53
 * @version V1.0
 */
public class TestFileIO {
	static String s = File.separator;

	private static void testInput() {
		// D�����и�Welcome.java�ļ������ڰ��ֽڶ��룺
		int a = 0;
		// int counter=0;
		FileInputStream f11;
		// ������
		try {
			f11 = new FileInputStream("D:" + s + "Welcome.java");
			while ((a = f11.read()) != -1)
				System.out.print((char) a); // �����ǰ��ֽ�����������ַ��޷������������Ϊһ�������ַ�ʱ�����ֽڡ�
			System.out
					.println("\n\n--------------------------------------------------\n");

			FileReader f12 = new FileReader("D:" + s + "Welcome.java");
			while ((a = f12.read()) != -1)
				System.out.print((char) a);// �����ǰ��ַ�����������ַ��������������
			System.out
					.println("\n\n--------------------------------------------------\n");

			f11.close();// ����֮��Ҫ�ر��ļ�
			f12.close();// ����֮��Ҫ�ر��ļ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testOutput() {
		// D�����и�Welcome.java�ļ������ڰ��ֽڶ��룺
		int a = 0;
		// �����
		File f21 = new File("D:" + s + "testFile" + s + "test1.txt");// ����һ���µ��ļ�f21��Ȼ���ж�����һĿ¼���Ƿ���ڣ���������ڣ��򴴽�֮��
		if (!f21.exists()) {
			f21.getParentFile().mkdirs();
			try {
				f21.createNewFile();
				// ����Welcome.java�������ݸ��Ƶ�f21
				FileOutputStream fos = new FileOutputStream(f21);
				FileInputStream fis = new FileInputStream("D:" + s
						+ "Welcome.java");// ���롰Welcome.java���ļ�
				while ((a = fis.read()) != -1)
					fos.write(a);// ��������ڴ�д��fos�У����ڵõ���test1��txt���Ǹ���Welcome��java��

				// writer��
				FileWriter f22 = new FileWriter("D:" + s + "testFile" + s
						+ "test2.txt");
				for (int i = 0; i < 65535; i++)
					f22.write(i);// ��
									// д�뵽test2.txt�С�������Ҳ���Կ���������35-38���ж��ļ��Ƿ���ڵ����Ҳ���Բ�Ҫ��
				// ���ļ���д���ַ���
				FileWriter f23 = new FileWriter("D:" + s + "testFile" + s
						+ "test3.txt");
				f23.write("Hello, world!");

				fos.close();
				fis.close();
				f22.close();
				f23.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void testBufferring() {
		// D�����и�Welcome.java�ļ������ڰ��ֽڶ��룺
		int a = 0, counter = 0;
		// �����ַ���ʵ�ָ�Чд��
		// BufferedWriter f31=new BufferedWriter(new
		// FileWriter("D"+s+"testFile"+s+"test4.txt"));
		BufferedWriter f31;
		try {
			f31 = new BufferedWriter(new FileWriter("D:" + s + "testFile" + s
					+ "test4.txt"));
			for (int i = 1; i <= 100; i++) {
				f31.write(String.valueOf(new Random().nextInt(100)) + " ");
				if (i % 10 == 0)
					f31.newLine();
			}
			f31.flush();// ˢ�»���
			f31.close();

			BufferedReader f32 = new BufferedReader(new FileReader("D:" + s
					+ "testFile" + s + "test4.txt"));
			String s32;
			System.out.println("����ļ�f32�����ݣ�");
			while ((s32 = f32.readLine()) != null)
				System.out.println(s32);
			f32.close();
			System.out .println("\n--------------------------------------------------\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testZip() {
		try {
			File f1 = new File("D:/test.zip");
			File f2 = new File("D:/testFile/testzip");
			ZipFile zf = new ZipFile(f1);
			testZipToUnzip(zf, f2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ѹ����zipfile��ѹ��file��
	public static void testZipToUnzip(ZipFile zipfile, File file) {
		ZipEntry zentry = null;
		File zipout;
		InputStream zis = null;
		FileOutputStream fos = null;
		Enumeration e = zipfile.entries();// zipfile��Ŀ¼

		while (e.hasMoreElements()) {
			zentry = (ZipEntry) e.nextElement();
			System.out.println(zentry.getName());// zipfile������Щ�ļ�������Ϊʲô����˳���������

			// ����ѹ����ļ��ŵ�file�ļ����£�
			zipout = new File(file + s + zentry.getName());

			if (!zentry.isDirectory()) {
				try {
					zis = zipfile.getInputStream(zentry);
					if (!zipout.exists())
						zipout.getParentFile().mkdirs();
					fos = new FileOutputStream(zipout);
					byte[] b = new byte[1024];
					int length;
					while ((length = zis.read(b)) > 0) {
						fos.write(b, 0, length);
					}
					fos.close();
					zis.close();
				} catch (ZipException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws ZipException {
		// TODO Auto-generated method stub

		testInput();
		testOutput();
		testBufferring();
		testZip();
	}
}
