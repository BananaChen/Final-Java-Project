package windows;

import java.util.ArrayList;

import items.*;
import person.Alien;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage4Factory implements SceneFactory{

	@Override
	public ArrayList<Person> createPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person = new Alien(10, 10, 0, 0, 0, 0);
		person.lb.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Aircraft> createAircraft() {
		ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
		Aircraft aircraft = new UFO(30, 20, 10, 0, 0, 0,"https://i.imgur.com/4G0ZiGK.gif");
		aircrafts.add(aircraft);
		
		return aircrafts;
	}

	@Override
	public ArrayList<Destination> createDestination() {
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		Destination destination = new BlueMoon(1200, 830, 1, 1, 1, 1, "https://i.imgur.com/91LhC53.png");
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Disturbance> createDisturbance() {
		ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();
		Disturbance blackhole1 = new BlackHole1(850, 600, 0, 0, 0, 0);
		Disturbance blackhole2 = new BlackHole2(1650, 300, 0, 0, 0, 0);
		Disturbance magnetic1 = new Magnetic1(0, 300, 0, 0, 0, 0);
		Disturbance magnetic2 = new Magnetic2(600, 800, 0, 0, 0, 0);
		Disturbance magnetic3 = new Magnetic3(1720, 500, 0, 0, 0, 0);
		Disturbance planet1 = new Planet1(1000, 150, 0, 0, 0, 0);
		
		disturbances.add(blackhole1);
		disturbances.add(blackhole2);
		disturbances.add(magnetic1);
		disturbances.add(magnetic2);
		disturbances.add(magnetic3);
		disturbances.add(planet1);
		
		return disturbances;
	}

}
