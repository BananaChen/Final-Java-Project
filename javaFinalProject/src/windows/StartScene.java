package windows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScene extends Scene implements ActionListener {

	public StartScene() {

		super();
		
		bgImagePath = "https://i.imgur.com/RvxJ1mC.gif";
		setWindow(bgImagePath);
		
		startTimer();
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
		wp.brush();
		
	}

}
