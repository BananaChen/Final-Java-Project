package command;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;
import windows.WindowController;

public class NextStageCommand implements Command{

	@Override
	public void execute(JPanel imagePanel, Scene scene, boolean isPassed, Timer timer,
			ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		
		System.out.println("N pressed");
		if (isPassed == true) {
			timer.stop();
			imagePanel.removeAll();
			// go to next stage
			WindowController.setStage(scene.getNextStage());
			System.out.println("go to next stage");
			isPassed = false;
			imagePanel.setFocusable(false);
		}
	}

}
