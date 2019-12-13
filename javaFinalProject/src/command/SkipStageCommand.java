package command;

import windows.Scene;

public class SkipStageCommand implements Command{

	Scene scene;

	@Override
	public void execute(Scene scene) {
		this.scene = scene;
		this.scene.skipToNextStage();
		
	}
}
