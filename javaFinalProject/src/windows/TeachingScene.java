package windows;

import java.awt.event.*;

public class TeachingScene extends Scene implements ActionListener {

	public TeachingScene() {

		super();
		
		factory = new TeachingSceneFactory();
		addElementToPanel(factory);

		bgImagePath = "https://i.imgur.com/BDmnRVK.jpg";
		setWindow(bgImagePath);

		startTimer();
	}

	@Override
	public Scene getCurrentStage() {
		return new TeachingScene();
	}

	@Override
	public Scene getNextStage() {
		return new Stage1();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		performAction();
	}

}