package windows;

import java.util.ArrayList;

import items.*;
import person.Turtle;
import aircraft.*;
import destination.*;
import disturbance.*;

public class Stage3Factory implements SceneFactory{

	@Override
	public ArrayList<Items> createPerson() {
		ArrayList<Items> persons = new ArrayList<Items>();
		Person person = new Turtle(0, 0, 1, 0, 0, 0.1, "https://i.imgur.com/A05MTnq.gif");
		person.lb.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Items> createAircraft() {
		ArrayList<Items> aircrafts = new ArrayList<Items>();
		Aircraft aircraft = new Mario(50, 200, 10, 0, 0, 0);
		aircrafts.add(aircraft);
		return aircrafts;
	}

	@Override
	public ArrayList<Items> createDestination() {
		ArrayList<Items> destinations = new ArrayList<Items>();
		Destination destination = new Flower(1250, 450, 0, 0, 0, 0, "https://i.imgur.com/iINy5rj.gif");
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Items> createDisturbance() {
		ArrayList<Items> disturbances = new ArrayList<Items>();
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
		
		disturbances.add(spring);
		disturbances.add(smallLight);
		disturbances.add(bigLight);
		disturbances.add(upPipe);
		disturbances.add(downPipe);
		disturbances.add(road);
		disturbances.add(rightPipe);
		disturbances.add(leftPipe);
		
		return disturbances;
	}

}
