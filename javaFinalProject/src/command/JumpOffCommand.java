package command;

import windows.Scene;

public class JumpOffCommand implements Command{
	
	Scene scene;
	
	public JumpOffCommand(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void execute() {
		this.scene.jumpOff();
	}

}
