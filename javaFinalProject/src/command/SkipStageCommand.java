package command;

import windows.Scene;

public class SkipStageCommand implements Command{

	Scene scene;

	public SkipStageCommand(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void execute() {
		this.scene.skipCurrentStage();
		
	}
}
