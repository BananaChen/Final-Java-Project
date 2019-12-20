package command;

import windows.Scene;

public class NextStageCommand implements Command{

	Scene scene;
	
	public NextStageCommand(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void execute() {
		this.scene.goToNextStage();
	}

}