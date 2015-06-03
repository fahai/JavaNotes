package org.fahai.jikexueyuan.pattern.command;

import org.fahai.common.BaseObject;
import org.fahai.jikexueyuan.pattern.command.device.Light;
import org.fahai.jikexueyuan.pattern.command.device.Stereo;

public class MyController extends BaseObject{

	private Light light;
	private Stereo stereo;
	
	public MyController(String light, String stereo){
		this.light = new Light(light);
		this.stereo = new Stereo(stereo);
	}
	
	public void on(int slot){
		switch (slot) {
		case 1:
			light.on();
			break;
		case 2:
			stereo.on();
			break;
		case 3:
			stereo.turnUpVol();
			break;
		default:
			log.info("command not defined");
			break;
		}
	}
	
	public void off(int slot){
		switch (slot) {
		case 1:
			light.off();
			break;
		case 2:
			stereo.off();
			break;
		case 3:
			stereo.turnDownVol();
			break;
		default:
			log.info("command not defined");
			break;
		}
	}
	
	public static void main(String[] args) {
		MyController my = new MyController("bedroom", "master");
		my.on(1);
		my.on(2);
		my.on(3);
		my.off(3);
		my.off(3);
		my.off(2);
		my.off(1);
	}
	
}
