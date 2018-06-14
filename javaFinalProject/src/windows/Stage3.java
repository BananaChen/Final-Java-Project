package windows;

import aircraft.*;
import destination.Flower;
import disturbance.*;
import items.*;
import person.Turtle;

import javax.swing.*;

import java.awt.event.*;

public class Stage3 extends Scene implements ActionListener {

	private BigFan bigfan;
	private MarioSpring spring;
	private SmallLight smallLight;
	private BigLight bigLight;
	private UpPipe upPipe;
	private DownPipe downPipe;
	private Road road;
	private Road rightPipe;
	private Road leftPipe;
	
	public Stage3() {
		
		super();
		// Timer
		timer = new Timer(10, this);
		
		//create Persons
		Person person = new Turtle(0, 0, 1, 0, 0, 0.1, "https://i.imgur.com/A05MTnq.gif");
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);		

		//create Destinations
		Destination destination = new Flower(1250, 450, 0, 0, 0, 0, "https://i.imgur.com/iINy5rj.gif");
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);
		
		//create Disturbances
		spring = new MarioSpring(100, 660, 0, 0, 0, 0);
		imagePanel.add(spring.lb);
		disturbances.add(spring);
		
		smallLight = new SmallLight(450 , 400, 0, 0, 0, 0);
		imagePanel.add(smallLight.lb);
		disturbances.add(smallLight);
		
		bigLight = new BigLight(900 , 400, 0, 0, 0, 0);
		imagePanel.add(bigLight.lb);
		disturbances.add(bigLight);
		
		upPipe = new UpPipe(600 ,-100, 0, 0, 0, 0);
		imagePanel.add(upPipe.lb);
		disturbances.add(upPipe);
		
		downPipe = new DownPipe(600 ,600, 0, 0, 0, 0);
		downPipe.setImage(600, 320, 200, 430, "https://i.imgur.com/SlaRZLw.png");
		imagePanel.add(downPipe.lb);
		disturbances.add(downPipe);
		
		road = new Road(0 , 300, 0, 0, 0, 0, "https://i.imgur.com/wz1WDDg.jpg");
		imagePanel.add(road.lb);
		disturbances.add(road);
		
		rightPipe = new Road(300, 400, 0, 0, 0, 0, "https://i.imgur.com/NaARvoD.png");
		rightPipe.setImage(300, 180,  100, 130, "https://i.imgur.com/NaARvoD.png");
		imagePanel.add(rightPipe.lb);
		disturbances.add(rightPipe);
		
		leftPipe = new Road(0, 400, 0, 0, 0, 0, "https://i.imgur.com/1Y60ahd.png");
		leftPipe.setImage(0, 180,  50, 130, "https://i.imgur.com/1Y60ahd.png");
		imagePanel.add(leftPipe.lb);
		disturbances.add(leftPipe);
		
		//create Aircrafts
		Aircraft aircraft = new Mario(50, 200, 10, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		//set window
		bgImagePath = "https://i.imgur.com/pLHkh4G.jpg";
		setWindow(bgImagePath);
		//imagePanel.setLocation(0,-100);
		
		// start timer
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		wp.brush();
		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			person.move();
		}
		for (int i = 0; i < aircrafts.size(); ++i) {
			aircrafts.get(i).move();
		}
		for (int i = 0; i < disturbances.size(); ++i) {
		    disturbances.get(i).effect(persons);
		}
		for (int i = 0; i < destinations.size(); ++i) {
		    destinations.get(i).effect(persons, this);
		}
	}
	
	@Override
	public Scene getCurrentStage() {
		return new Stage3();
	}

	@Override
	public Scene getNextStage() {
		return new Stage4();
	}
}
