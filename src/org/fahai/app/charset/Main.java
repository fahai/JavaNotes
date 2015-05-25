/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.charset;

/**
 * 描述： 批量转换文件编码
 * 使用： java Main srcPath destPath
 * 原理： 检测文件编码； 根据文件编码读文件； 把文件内容以UTF-8格式写到目标路径
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class Main {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		
		FileUtils tool = new FileUtils();
		tool.convertToUTF8(args[1], args[2]);

	}

}
