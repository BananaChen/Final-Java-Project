package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;

public class TeachingSceneFactory implements SceneFactory{

	@Override
	public CompositeItem createPerson(CompositeItem compositeItems) {
		Person person = new NormalPerson(0, 0, 1, 1, 0, 0.01);
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
		Destination destination = new Island(1000, 500, 1, 1, 1, 1);
		compositeItems.addItem(destination);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDisturbance(CompositeItem compositeItems) {
		return compositeItems;
	}
}
