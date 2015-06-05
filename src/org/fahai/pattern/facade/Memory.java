package org.fahai.pattern.facade;

import org.fahai.common.LogInterface;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class Memory implements LogInterface {
	
	public void startup(){
		String clazzName = this.getClass().getSimpleName();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info(clazzName + " " + methodName);
	}
	
	public void shutdown(){
		String clazzName = this.getClass().getSimpleName();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info(clazzName + " " + methodName);
	}
}
