package org.fahai.common;

import org.apache.log4j.Logger;

public class BaseObject {
	
	protected Logger log;
	
	public BaseObject(){
		log = Logger.getLogger(BaseObject.class);
	}

}
