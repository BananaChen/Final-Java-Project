package windows;


public class StartScene extends Scene{

	public StartScene() {

		super();
		
		// set window
		bgImagePath = "https://i.imgur.com/RvxJ1mC.gif";
		setWindow(bgImagePath);
		
	}
	
	
	@Override
	public Scene getCurrentStage() {
		return new StartScene();
	}

	@Override
	public Scene getNextStage() {
		return new TeachingScene();
	}
	


}
