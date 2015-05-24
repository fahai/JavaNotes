package org.fahai.thinkinginjava.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeInfo implements Iterator<File> {
	
	public List<File> files = new ArrayList<File>();
	public List<File> dirs = new ArrayList<File>();
	
	public Iterator<File> iterator(){
		return files.iterator();
	}
	
	void addAll(TreeInfo other){
		this.files.addAll(other.files);
		this.dirs.addAll(other.dirs);
	}
	
	public String toString(){
		return "dirs: " + PPrint.pformat(dirs) + 
				"\n\nfiles: " + PPrint.pformat(files);
	}
	
	public static TreeInfo walk(String start, String regex){
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(File start, String regex){
		return recurseDirs(start, regex);
	}
	
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
	
	public static TreeInfo recurseDirs(File start, String regex){
		TreeInfo result = new TreeInfo();
		for(File item : start.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));;
			}else{
				if(item.getName().matches(regex)){
					result.files.add(item);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println(walk("."));
		}else{
			for(String arg : args){
				System.out.println(walk(arg));
			}
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public File next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
