package windows;

import items.*;
import aircraft.*;
import destination.*;
import disturbance.*;
import disturbance.Spring;

import javax.swing.*;
import java.awt.event.*;

public class Stage1 extends Scene implements ActionListener {
	
	private double gravity = 0.005;
	private Disturbance bigfan, spring;

	public Stage1() {

		super();

		// Timer
		timer = new Timer(10, this);
		
		// declare elements in scene
		
		
		Person person = new Person(0, 0, 1, 1, 0, gravity);
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		Destination destination = new Island(650, 500, 0, 0, 0, 0);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		bigfan = new BigFan(0, 200, 0, 0, 0, 0);
		imagePanel.add(bigfan.lb);
		disturbances.add(bigfan);

		spring = new Spring(1700, 500, 0, 0, 0, 0);
		imagePanel.add(spring.lb);
		disturbances.add(spring);

		// key event
		// imagePanel.setFocusable(true);
		// this.imagePanel.addKeyListener(keyAdapter);

		// set window
		bgImagePath = "https://i.imgur.com/NEDwmd1.png";
		setWindow(bgImagePath);

		// start timer
		timer.start();
	}
	
	@Override
	public Scene getCurrentStage() {
		return new Stage1();
	}

	@Override
	public Scene getNextStage() {
		return new Stage2();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		wp.brush();
		for (int i = 0; i < persons.size(); ++i) {
			persons.get(i).move();
		}
		for (int i = 0; i < aircrafts.size(); ++i) {
			aircrafts.get(i).move();
			if (aircrafts.get(i).getPositionX() > bgWidth) {
				aircrafts.get(i).setPositionX(-aircrafts.get(i).imageWidth);
			}
		}
		for (int i = 0; i < disturbances.size(); ++i) {
			disturbances.get(i).effect(persons);
		}
		for (int i = 0; i < destinations.size(); ++i) {
			destinations.get(i).effect(persons, this);
		}
	}

}
