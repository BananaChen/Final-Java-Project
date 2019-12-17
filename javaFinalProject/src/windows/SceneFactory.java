package windows;

import items.CompositeItem;

public interface SceneFactory {
	public CompositeItem createPerson(CompositeItem compositeItems);
	public CompositeItem createAircraft(CompositeItem compositeItems);
	public CompositeItem createDestination(CompositeItem compositeItems);
	public CompositeItem createDisturbance(CompositeItem compositeItems);
}
