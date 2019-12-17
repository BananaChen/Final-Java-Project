package windows;

import java.util.ArrayList;

import items.Aircraft;
import items.Destination;
import items.Disturbance;
import items.Items;
import items.Person;

public interface SceneFactory {
	public ArrayList<Items> createPerson();
	public ArrayList<Items> createAircraft();
	public ArrayList<Items> createDestination();
	public ArrayList<Items> createDisturbance();
}
