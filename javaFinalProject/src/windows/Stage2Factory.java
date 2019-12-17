package windows;

import java.util.ArrayList;

import items.*;
import person.Thug;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage2Factory implements SceneFactory{

	@Override
	public ArrayList<Items> createPerson() {
		ArrayList<Items> persons = new ArrayList<Items>();
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
	public ArrayList<Items> createAircraft() {
		ArrayList<Items> aircrafts = new ArrayList<Items>();
		Aircraft aircraft = new Bee(0, 50, 0, 0, 0.1, 0.1, "https://i.imgur.com/kE4cmKB.png");
		aircrafts.add(aircraft);
		
		return aircrafts;
	}

	@Override
	public ArrayList<Items> createDestination() {
		ArrayList<Items> destinations = new ArrayList<Items>();
		Destination destination = new Honeycomb(700, 700, 1, 1, 1, 1, "https://i.imgur.com/LqQXJuJ.png");
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Items> createDisturbance() {
		ArrayList<Items> disturbances = new ArrayList<Items>();
		for (int i = 0; i < 2; ++i) {
			disturbances.add(new Arrow(0, 700, 0, 0, 0, 0, "https://i.imgur.com/rhhmCwP.png"));
		}
		
		return disturbances;
	}

}
