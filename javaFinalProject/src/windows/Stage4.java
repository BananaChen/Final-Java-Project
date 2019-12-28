package windows;

import java.awt.event.*;

public class Stage4 extends Scene implements ActionListener {

	public Stage4() {
		
		super();

		factory = new Stage4Factory();
		
		addElementToPanel(factory);

		bgImagePath = "https://i.imgur.com/jrWlbHA.jpg";
		setWindow(bgImagePath);
		
		startTimer();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		performAction();
	}

	@Override
	public Scene getCurrentStage() {
		return new Stage4();
	}

	@Override
	public Scene getNextStage() {
		return new Stage5();
	}

}
