package command;

import windows.Scene;

public class ReplayCommand implements Command{

	Scene scene;
	
	public ReplayCommand(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void execute() {
		this.scene.replay();
	}

}
