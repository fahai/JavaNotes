package org.fahai.jikexueyuan.pattern.command.device;

import org.apache.log4j.Logger;

public class Stereo {
	
	private static Logger logger = Logger.getLogger(Stereo.class);
	
	private String name;
	private int vol = 0;
	
	public int getVol() {
		return vol;
	}

//	public void setVol(int vol) {
//		this.vol = vol;
//	}

	public Stereo(String name){
		this.name = name;
	}
	
	public void on(){
		logger.info(name + " stereo on ");
	}
	
	public void off(){
		logger.info(name + " stereo off ");
	}
	
	public int turnUpVol(){
		if(vol < 10){
			vol++;
		}
		logger.info(name + " vol is " + vol);
		return vol;
	}
	
	public int turnDownVol(){
		if(vol > 0){
			vol--;
		}
		logger.info(name + " vol is " + vol);
		return vol;
	}

}
