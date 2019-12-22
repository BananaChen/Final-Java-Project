package command;

import java.util.ArrayList;

import items.Items;
import items.Person;

public class JumpOffCommand implements Command{
	
	ArrayList<Items> persons;
	
	public JumpOffCommand(ArrayList<Items> persons) {
		this.persons = persons;
	}
	
	@Override
	public void execute() {
		for (Items person : this.persons) {
			((Person) person).parachute();
		}
	}

}
