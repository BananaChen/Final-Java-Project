package command;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;
import windows.WindowController;

public class SkipStageCommand implements Command{

	@Override
	public void execute(JPanel imagePanel, Scene scene, boolean isPassed, Timer timer, ArrayList<Person> persons,
			ArrayList<Aircraft> aircrafts) {
		System.out.println("Enter pressed");
		timer.stop();
		imagePanel.removeAll();
		WindowController.setStage(scene.getNextStage());
		isPassed = false;
		imagePanel.setFocusable(false);
		
	}

}
