/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.charset;

import java.io.File;
import java.io.FileFilter;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 21, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TextFileFilter implements FileFilter{
	
	private String[] types;
	
	public TextFileFilter(String fileType){
		types = fileType.split(";");
	}

	@Override
	public boolean accept(File pathname) {
		for(String type : types){
			if(pathname.getName().endsWith(type)){
				return false;
			}
		}
		return true;
	}

}
