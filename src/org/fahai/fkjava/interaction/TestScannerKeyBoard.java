/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.interaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 22, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TestScannerKeyBoard {
	
	private static Logger logger = Logger.getLogger(TestScannerKeyBoard.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while(sc.hasNext()){
//			logger.info("You Input: " + sc.next());
//		}
//		while(sc.hasNextInt()){
//			logger.info("You Input:" + sc.nextInt());
//		}
		
		// 读取文件
		try {
			Scanner sc = new Scanner(new File(".\\src\\log4j.properties"));
			while(sc.hasNextLine()){
				logger.info(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
