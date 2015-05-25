package org.fahai.thinkinginjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Produce a sequence of File objects that match a
 * regular expression in either a local directory.
 * or by walking a directory
 * @author fahai
 *
 */
public final class Directory {
	
	public static File[] local(File dir, String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern;
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
			
		});
	}
	
	// Overload
	public static File[] local(String path, final String regex){
		return local(new File(path), regex);
	}

}


