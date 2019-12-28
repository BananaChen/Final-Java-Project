package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScene extends Scene implements ActionListener {
	public EndScene() {

		super();
		
		bgImagePath = "https://i.imgur.com/S9eWdsK.jpg";
		setWindow(bgImagePath);
		
		startTimer();
	}
	

	@Override
	public Scene getCurrentStage() {
		return new EndScene();
	}

	@Override
	public Scene getNextStage() {
		return new Stage1();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		wp.brush();
		
	}
	
}
