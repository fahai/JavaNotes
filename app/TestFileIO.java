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
 * @date 2014-7-22 下午03:17:53
 * @version V1.0
 */
public class TestFileIO {
	static String s = File.separator;

	private static void testInput() {
		// D盘下有个Welcome.java文件，现在按字节读入：
		int a = 0;
		// int counter=0;
		FileInputStream f11;
		// 输入流
		try {
			f11 = new FileInputStream("D:" + s + "Welcome.java");
			while ((a = f11.read()) != -1)
				System.out.print((char) a); // 这里是按字节输出，中文字符无法正常输出，因为一个中文字符时两个字节。
			System.out
					.println("\n\n--------------------------------------------------\n");

			FileReader f12 = new FileReader("D:" + s + "Welcome.java");
			while ((a = f12.read()) != -1)
				System.out.print((char) a);// 这里是按字符输出，中文字符都可以正常输出
			System.out
					.println("\n\n--------------------------------------------------\n");

			f11.close();// 读完之后要关闭文件
			f12.close();// 读完之后要关闭文件
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testOutput() {
		// D盘下有个Welcome.java文件，现在按字节读入：
		int a = 0;
		// 输出流
		File f21 = new File("D:" + s + "testFile" + s + "test1.txt");// 定义一个新的文件f21，然后判断在这一目录下是否存在，如果不存在，则创建之。
		if (!f21.exists()) {
			f21.getParentFile().mkdirs();
			try {
				f21.createNewFile();
				// 将“Welcome.java”的内容复制到f21
				FileOutputStream fos = new FileOutputStream(f21);
				FileInputStream fis = new FileInputStream("D:" + s
						+ "Welcome.java");// 读入“Welcome.java”文件
				while ((a = fis.read()) != -1)
					fos.write(a);// 将读入的内存写到fos中，现在得到的test1。txt就是复制Welcome。java的

				// writer类
				FileWriter f22 = new FileWriter("D:" + s + "testFile" + s
						+ "test2.txt");
				for (int i = 0; i < 65535; i++)
					f22.write(i);// 将
									// 写入到test2.txt中。由这里也可以看出，上面35-38行判断文件是否存在的语句也可以不要。
				// 向文件中写入字符串
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
		// D盘下有个Welcome.java文件，现在按字节读入：
		int a = 0, counter = 0;
		// 缓冲字符，实现高效写入
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
			f31.flush();// 刷新缓冲
			f31.close();

			BufferedReader f32 = new BufferedReader(new FileReader("D:" + s
					+ "testFile" + s + "test4.txt"));
			String s32;
			System.out.println("输出文件f32的内容：");
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

	// 将压缩包zipfile解压到file中
	public static void testZipToUnzip(ZipFile zipfile, File file) {
		ZipEntry zentry = null;
		File zipout;
		InputStream zis = null;
		FileOutputStream fos = null;
		Enumeration e = zipfile.entries();// zipfile的目录

		while (e.hasMoreElements()) {
			zentry = (ZipEntry) e.nextElement();
			System.out.println(zentry.getName());// zipfile下有哪些文件？可是为什么不按顺序输出？？

			// 将解压后的文件放到file文件夹下：
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
