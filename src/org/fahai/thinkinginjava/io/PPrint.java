package org.fahai.thinkinginjava.io;

import java.util.Arrays;
import java.util.Collection;

/**
 * pretty-printer for collections
 * @author fahai
 *
 */
public class PPrint {

	public static String pformat(Collection<?> c) {
		if(c.size() == 0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[]");
		for(Object item : c){
			if(c.size() != 1){
				sb.append("\n  ");
			}
			sb.append(item.toString());
		}
		if(c.size() != 1){
			sb.append("\n  ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void pprint(Collection<?> c){
		System.out.println(pformat(c));
	}
	
	public static void pprint(Object[] c){
		System.out.println(Arrays.asList(c));
	}

}
