package command;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;

public interface Command {
	public void execute(JPanel imagePanel, Scene scene, boolean isPassed, Timer timer, ArrayList<Person> persons, ArrayList<Aircraft> aircrafts);
}
