package windows;

import java.util.ArrayList;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage1Factory implements SceneFactory{

	private double gravity = 0.005;

	@Override
	public ArrayList<Items> createPerson() {
		ArrayList<Items> persons = new ArrayList<Items>();
		Person person = new NormalPerson(0, 0, 1, 1, 0, gravity);
		person.lb.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Items> createAircraft() {
		ArrayList<Items> aircrafts = new ArrayList<Items>();
		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		return aircrafts;
	}

	@Override
	public ArrayList<Items> createDestination() {
		ArrayList<Items> destinations = new ArrayList<Items>();
		Destination destination = new Island(650, 500, 0, 0, 0, 0);
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Items> createDisturbance() {
		ArrayList<Items> disturbances = new ArrayList<Items>();
		Disturbance bigfan = new BigFan(0, 200, 0, 0, 0, 0);
		Disturbance spring = new Spring(1700, 500, 0, 0, 0, 0);
		disturbances.add(bigfan);
		disturbances.add(spring);
		
		return disturbances;
	}

	

}
