package windows;

import java.awt.event.*;

public class Stage1 extends Scene implements ActionListener {
	
	public Stage1() {

		super();
		
		factory = new Stage1Factory();
		addElementToPanel(factory);
		
		bgImagePath = "https://i.imgur.com/NEDwmd1.png";
		setWindow(bgImagePath);
		
		startTimer();
	}
	
	@Override
	public Scene getCurrentStage() {
		return new Stage1();
	}

	@Override
	public Scene getNextStage() {
		return new Stage2();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		performAction();
	}

}
