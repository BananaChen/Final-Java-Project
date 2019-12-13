package windows;

import java.util.ArrayList;

import items.*;
import aircraft.*;
import destination.*;
import disturbance.*;

public class TeachingSceneFactory implements SceneFactory{

	@Override
	public ArrayList<Person> createPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person = new Person(0, 0, 1, 1, 0, 0.01);
		person.lb.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Aircraft> createAircraft() {
		ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		return aircrafts;
	}

	@Override
	public ArrayList<Destination> createDestination() {
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		Destination destination = new Island(1000, 500, 1, 1, 1, 1);
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Disturbance> createDisturbance() {
		ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();
		
		return disturbances;
	}
}
