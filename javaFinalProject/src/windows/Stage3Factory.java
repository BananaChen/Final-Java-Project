package windows;

import items.*;
import person.Turtle;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage3Factory implements SceneFactory{

	@Override
	public CompositeItem createPerson(CompositeItem compositeItems) {
		Person person = new Turtle(0, 0, 1, 0, 0, 0.1, "https://i.imgur.com/A05MTnq.gif");
		person.lb.setVisible(false);
		compositeItems.addItem(person);
		
		return compositeItems;
		
	}

	@Override
	public CompositeItem createAircraft(CompositeItem compositeItems) {
		Aircraft aircraft = new Mario(50, 200, 10, 0, 0, 0);
		compositeItems.addItem(aircraft);
		return compositeItems;
	}

	@Override
	public CompositeItem createDestination(CompositeItem compositeItems) {
		Destination destination = new Flower(1250, 450, 0, 0, 0, 0, "https://i.imgur.com/iINy5rj.gif");
		compositeItems.addItem(destination);
		
		return compositeItems;
	}

	@Override
	public CompositeItem createDisturbance(CompositeItem compositeItems) {
		Disturbance spring = new MarioSpring(100, 660, 0, 0, 0, 0);
		Disturbance smallLight = new SmallLight(450 , 400, 0, 0, 0, 0);
		Disturbance bigLight = new BigLight(900 , 400, 0, 0, 0, 0);
		Disturbance upPipe = new UpPipe(600 ,-100, 0, 0, 0, 0);
		Disturbance downPipe = new DownPipe(600 ,600, 0, 0, 0, 0);
		downPipe.setImage(600, 320, 200, 430, "https://i.imgur.com/SlaRZLw.png");
		Disturbance road = new Road(0 , 300, 0, 0, 0, 0, "https://i.imgur.com/wz1WDDg.jpg");
		Disturbance rightPipe = new Road(300, 400, 0, 0, 0, 0, "https://i.imgur.com/NaARvoD.png");
		rightPipe.setImage(300, 180,  100, 130, "https://i.imgur.com/NaARvoD.png");
		Disturbance leftPipe = new Road(0, 400, 0, 0, 0, 0, "https://i.imgur.com/1Y60ahd.png");
		leftPipe.setImage(0, 180,  50, 130, "https://i.imgur.com/1Y60ahd.png");
		
		compositeItems.addItem(spring);
		compositeItems.addItem(smallLight);
		compositeItems.addItem(bigLight);
		compositeItems.addItem(upPipe);
		compositeItems.addItem(downPipe);
		compositeItems.addItem(road);
		compositeItems.addItem(rightPipe);
		compositeItems.addItem(leftPipe);
		
		return compositeItems;
	}

}
