package windows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartScene extends Scene implements ActionListener{

	public StartScene() {

		super();
		
		// set window
		bgImagePath = "https://i.imgur.com/RvxJ1mC.gif";
		setWindow(bgImagePath);
		timer = new Timer(10, this);
		timer.start();
	}
	
	
	@Override
	public Scene getCurrentStage() {
		return new StartScene();
	}

	@Override
	public Scene getNextStage() {
		return new TeachingScene();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
