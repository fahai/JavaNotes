package org.fahai.pattern.command;

public class MyCommand implements Command {
	
	private Soldier soldier;
	
	public MyCommand(Soldier soldier){
		this.soldier = soldier;
	}

	@Override
	public void execute() {
		log.info("transfer the command... ");
		soldier.action();
	}

}
