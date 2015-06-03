/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.jikexueyuan.pattern.command.command;

import org.fahai.common.BaseObject;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    Jun 3, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class LightOffCommand extends BaseObject implements Command {

	@Override
	public void off() {
		String clazzName = this.getClass().getSimpleName();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info(clazzName + " " + methodName);
	}

	@Override
	public void on() {
	}

	@Override
	public void trunDownVol() {
	}

	@Override
	public void trunUpVol() {
	}

}
