package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage1Factory implements SceneFactory{

	private double gravity = 0.005;

	@Override
	public CompositeItem createPerson(CompositeItem compositeItems) {
		Person person = new NormalPerson(0, 0, 1, 1, 0, gravity);
		person.setLabelVisibility(false);
		compositeItems.addItem(person);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createAircraft(CompositeItem compositeItems) {
		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		compositeItems.addItem(aircraft);
		return compositeItems;
	}

	@Override
	public CompositeItem createDestination(CompositeItem compositeItems) {
		Destination destination = new Island(650, 500, 0, 0, 0, 0);
		compositeItems.addItem(destination);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDisturbance(CompositeItem compositeItems) {
		Disturbance bigfan = new BigFan(0, 200, 0, 0, 0, 0);
		Disturbance spring = new Spring(1700, 500, 0, 0, 0, 0);
		compositeItems.addItem(bigfan);
		compositeItems.addItem(spring);
		
		return compositeItems;
	}
	

}
