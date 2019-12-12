package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class EndScene extends Scene implements ActionListener {
	public EndScene() {

		super();
		
		bgImagePath = "https://i.imgur.com/S9eWdsK.jpg";
//		bgImagePath = "https://i.imgur.com/RvxJ1mC.gif";
		setWindow(bgImagePath);
		
		timer = new Timer(10, this);
		timer.start();
	}
	

	@Override
	public Scene getCurrentStage() {
		// TODO Auto-generated method stub
		return new EndScene();
	}

	@Override
	public Scene getNextStage() {
		// TODO Auto-generated method stub
		return new Stage1();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		wp.brush();
		
	}
	
}
