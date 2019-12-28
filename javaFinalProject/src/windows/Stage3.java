package windows;

import java.awt.event.*;

public class Stage3 extends Scene implements ActionListener {
	
	public Stage3() {
		
		super();
		
		factory = new Stage3Factory();
		addElementToPanel(factory);
		
		bgImagePath = "https://i.imgur.com/pLHkh4G.jpg";
		setWindow(bgImagePath);
		
		startTimer();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		performAction();
	}
	
	@Override
	public Scene getCurrentStage() {
		return new Stage3();
	}

	@Override
	public Scene getNextStage() {
		return new Stage4();
	}

}
