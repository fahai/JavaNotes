package org.fahai.app.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class FileUtils {
	
	private static Logger logger = Logger.getLogger(FileUtils.class);
	public static ArrayList<File> fileList = new ArrayList<File>();
	
	public void getFiles(File directory){
		// ignore .class files
		File[] files = directory.listFiles(new TextFileFilter(".class"));
		for(File file : files){
			if(file.isDirectory()){
				getFiles(file);
			}else{
				fileList.add(file);
			}
		}
	}
	
	public String readFile(File file){
		StringBuilder sb = new StringBuilder();
		String charset = getFileEncoding(file);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), charset);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while((line=br.readLine()) != null){
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
			}
			br.close();
			isr.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}

	
	public boolean writeFile(File file, String fileContent, String charset){
		boolean isOK = false; 
		try {
			if(file.isDirectory()){
				if(!file.exists()){
					file.mkdir();
				}
			}else{
				if(!file.exists()){
					if(!file.getParentFile().exists()){
						file.getParentFile().mkdirs();
					}
					file.createNewFile();
				}
				OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), charset);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(fileContent);
				bw.close();
				osw.close();
				isOK = true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isOK;
	}
	
	public void convertToUTF8(String srcPath, String distPath){
		File srcDirectory = new File(srcPath);
		File destDirectory = new File(distPath);
		if(!(srcDirectory.isDirectory() && destDirectory.isDirectory())){
			logger.error("Source file or destination file is not a directory!");
		}
		fileList.clear();
		getFiles(srcDirectory);
		File destFile = null;
		for(File file : fileList){
			destFile = new File(destDirectory.getAbsolutePath() + file.getParent() + System.getProperty("file.separator") + file.getName());
			writeFile(destFile, readFile(file), "UTF-8");
		}
	}
	
	public static String getFileEncoding(File file){
        CharsetDetector charDect = new CharsetDetector();
        String[] charsets = null;
		try {
			charsets = charDect.detectChineseCharset(new FileInputStream(file));
		}catch (Exception e) {
			logger.error("Parse file charset error!");
			e.printStackTrace();
		}
        if(charsets.length>0){
        	return charsets[0];
        }else{
        	return "";
        }
	}

}
