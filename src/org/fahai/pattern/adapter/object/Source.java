/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.pattern.adapter.object;

import org.fahai.common.LogInterface;

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
public class Source implements LogInterface{
	
	public void sourceMethod(){
		log.info("This is source method.");
	}

}
