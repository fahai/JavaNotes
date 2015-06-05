/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.pattern.decorator;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    Jun 5, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class Decorator implements Sourceable {
	
	private Source source;
	
	public Decorator(Source source){
		super();
		this.source = source;
	}

	@Override
	public void method() {
		log.info("before invoke source method.");
		source.method();
		log.info("after invoke source method.");
	}

}
