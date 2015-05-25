/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.tmp;

import java.io.File;
import java.io.IOException;

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
public class KillIExplorer {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		File file = new File("C:\\Windows\\System32\\iccctrl3.ocx");
		boolean result = false;
		result = killIe(file, "iexplore.exe");
		System.out.println(result);
	}
	
	public static boolean killIe(File file, String lockAppName){
		boolean result = false;
		String cmd = "taskkill /f /im " + lockAppName;
		try {
			Runtime.getRuntime().exec(cmd);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
