package command;

import windows.Scene;

public class JumpOffCommand implements Command{
	
	Scene scene;
	
	@Override
	public void execute(Scene scene) {
		this.scene = scene;
		this.scene.jumpOff();
	}

}
