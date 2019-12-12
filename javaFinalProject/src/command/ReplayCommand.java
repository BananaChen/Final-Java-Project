package command;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;
import windows.WindowController;

public class ReplayCommand implements Command{

	@Override
	public void execute(JPanel imagePanel, Scene scene, boolean isPassed, Timer timer, ArrayList<Person> persons,
			ArrayList<Aircraft> aircrafts) {
		System.out.println("R pressed");
		if (isPassed == false) {
			timer.stop();
			imagePanel.removeAll();
			// restart current stage
			WindowController.setStage(scene.getCurrentStage());
			System.out.println("replay");
			isPassed = false;
			imagePanel.setFocusable(false);
		}
		
	}

}
