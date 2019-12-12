package command;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;

public class RemoteController {
	
	private HashMap<Integer, Command> controller = new HashMap<Integer, Command>();
	
	public RemoteController() {
		
	}
	
	public void setRemoteController(int key, Command control) {
		controller.put(key, control);
    }
	
	public void pressButton(int key, JPanel imagePanel, Scene scene, boolean isPassed, Timer timer,
			ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		if (controller.containsKey(key)) {
			controller.get(key).execute(imagePanel, scene, isPassed, timer, persons, aircrafts);
		}
	}
}
