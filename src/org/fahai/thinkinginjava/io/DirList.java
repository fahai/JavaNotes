package org.fahai.thinkinginjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Display a directory listing using regular expression
 * 可看作是策略模式的例子
 * list()实现了基本的功能,而DirFilter类提供了策略
 * list()回调accept()。
 * @author fahai
 *
 */
public class DirList {
	
	private static Logger logger = LogManager.getLogger(DirList.class);

	public static void main(String[] args){
		File path = new File(".");
		String[] list;
		if(args.length == 0){
			list = path.list();
		}else{
			list = path.list(new DirFilter(args[0]));
		}
		for(String dirItem : list){
//			logger.info(dirItem);
			System.out.println(dirItem);
		}
	}
	
}

class DirFilter implements FilenameFilter{
	
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
