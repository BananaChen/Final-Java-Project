package windows;

import java.util.ArrayList;

import items.*;
import person.Thug;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage2Factory implements SceneFactory{

	@Override
	public CompositeItem createPerson(CompositeItem compositeItems) {
		ArrayList<Items> persons = new ArrayList<Items>();
		Thug person = new Thug(50, 50, 1, 1, 0, 0);
		person.lb.setVisible(false);
		person.lbSunGlasses.setVisible(false);
		person.heart1.setVisible(false);
		person.heart2.setVisible(false);
		person.heart3.setVisible(false);
		compositeItems.addItem(person);
		
		return compositeItems;
		
	}

	@Override
	public CompositeItem createAircraft(CompositeItem compositeItems) {
		ArrayList<Items> aircrafts = new ArrayList<Items>();
		Aircraft aircraft = new Bee(0, 50, 0, 0, 0.1, 0.1, "https://i.imgur.com/kE4cmKB.png");
		compositeItems.addItem(aircraft);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDestination(CompositeItem compositeItems) {
		ArrayList<Items> destinations = new ArrayList<Items>();
		Destination destination = new Honeycomb(700, 700, 1, 1, 1, 1, "https://i.imgur.com/LqQXJuJ.png");
		compositeItems.addItem(destination);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDisturbance(CompositeItem compositeItems) {
		ArrayList<Items> disturbances = new ArrayList<Items>();
		for (int i = 0; i < 2; ++i) {
			compositeItems.addItem(new Arrow(0, 700, 0, 0, 0, 0, "https://i.imgur.com/rhhmCwP.png"));
		}
		
		return compositeItems;
	}

}
