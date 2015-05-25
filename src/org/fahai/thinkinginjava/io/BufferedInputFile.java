package org.fahai.thinkinginjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	
	public static String read(String filename){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while((line=in.readLine()) != null){
				sb.append(line + "\n");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(read("./src/org/fahai/thinkinginjava/io/BufferedInputFile.java"));
	}

}
