package windows;

import items.*;
import person.Alien;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage4Factory implements SceneFactory{

	@Override
	public CompositeItem createPerson(CompositeItem compositeItems) {
		Person person = new Alien(10, 10, 0, 0, 0, 0);
		person.lb.setVisible(false);
		compositeItems.addItem(person);
		
		return compositeItems;
		
	}

	@Override
	public CompositeItem createAircraft(CompositeItem compositeItems) {
		Aircraft aircraft = new UFO(30, 20, 10, 0, 0, 0,"https://i.imgur.com/4G0ZiGK.gif");
		compositeItems.addItem(aircraft);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDestination(CompositeItem compositeItems) {
		Destination destination = new BlueMoon(1200, 830, 1, 1, 1, 1, "https://i.imgur.com/91LhC53.png");
		compositeItems.addItem(destination);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDisturbance(CompositeItem compositeItems) {
		Disturbance blackhole1 = new BlackHole1(850, 600, 0, 0, 0, 0);
		Disturbance blackhole2 = new BlackHole2(1650, 300, 0, 0, 0, 0);
		Disturbance magnetic1 = new Magnetic1(0, 300, 0, 0, 0, 0);
		Disturbance magnetic2 = new Magnetic2(600, 800, 0, 0, 0, 0);
		Disturbance magnetic3 = new Magnetic3(1720, 500, 0, 0, 0, 0);
		Disturbance planet1 = new Planet1(1000, 150, 0, 0, 0, 0);
		
		compositeItems.addItem(blackhole1);
		compositeItems.addItem(blackhole2);
		compositeItems.addItem(magnetic1);
		compositeItems.addItem(magnetic2);
		compositeItems.addItem(magnetic3);
		compositeItems.addItem(planet1);
		
		return compositeItems;
	}

}
