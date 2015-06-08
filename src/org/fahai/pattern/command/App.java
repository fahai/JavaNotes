package org.fahai.pattern.command;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class App {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		Soldier soldier = new Soldier("SuperMan");
		Command command = new MyCommand(soldier);
		Commander commander = new Commander(command);
		commander.sendCommand();
	}

}
