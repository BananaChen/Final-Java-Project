package windows;

import java.util.ArrayList;

import items.*;
import person.Thug;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage2Factory implements SceneFactory{

	@Override
	public ArrayList<Person> createPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Thug person = new Thug(50, 50, 1, 1, 0, 0);
		person.lb.setVisible(false);
		person.lbSunGlasses.setVisible(false);
		person.heart1.setVisible(false);
		person.heart2.setVisible(false);
		person.heart3.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Aircraft> createAircraft() {
		ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
		Aircraft aircraft = new Bee(0, 50, 0, 0, 0.1, 0.1, "https://i.imgur.com/kE4cmKB.png");
		aircrafts.add(aircraft);
		
		return aircrafts;
	}

	@Override
	public ArrayList<Destination> createDestination() {
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		Destination destination = new Honeycomb(700, 700, 1, 1, 1, 1, "https://i.imgur.com/LqQXJuJ.png");
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Disturbance> createDisturbance() {
		ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();
		for (int i = 0; i < 2; ++i) {
			disturbances.add(new Arrow(0, 700, 0, 0, 0, 0, "https://i.imgur.com/rhhmCwP.png"));
		}
		
		return disturbances;
	}

}
