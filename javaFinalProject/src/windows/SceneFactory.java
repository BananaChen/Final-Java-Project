package windows;

import java.util.ArrayList;

import items.Aircraft;
import items.Destination;
import items.Disturbance;
import items.Person;

public interface SceneFactory {
	public ArrayList<Person> createPerson();
	public ArrayList<Aircraft> createAircraft();
	public ArrayList<Destination> createDestination();
	public ArrayList<Disturbance> createDisturbance();
}
