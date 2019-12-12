package command;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import items.Aircraft;
import items.Person;
import windows.Scene;

public class JumpOffCommand implements Command{
	
	public JumpOffCommand() {
	}

	@Override
	public void execute(JPanel imagePanel, Scene scene, boolean isPassed, Timer timer,
			ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		System.out.println("Down pressed");
		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (person.isDropped == false) {
				person.lb.setVisible(true);
				person.personInitPx = aircrafts.get(i).positionX + aircrafts.get(i).imageWidth / 2;
				person.personInitPy = aircrafts.get(i).positionY + aircrafts.get(i).imageHeight / 2;
				person.setMoveData(person.personInitPx, person.personInitPy, person.personInitVx,
						person.personInitVy, person.personInitAx, person.personInitAy);
				person.lb.setLocation((int) person.getPositionX(), (int) person.getPositionY());
				person.isDropped = true;
			}
		}
		
	}

}
