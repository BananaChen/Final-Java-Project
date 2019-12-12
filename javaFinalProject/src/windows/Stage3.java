package windows;

import aircraft.*;
import destination.Flower;
import disturbance.*;
import items.*;
import person.Turtle;

import javax.swing.*;

import java.awt.event.*;

public class Stage3 extends Scene implements ActionListener {
	
	public Stage3() {
		
		super();
		
		// Timer
		timer = new Timer(10, this);
		
		// declare concrete factory
		factory = new Stage3Factory();
		
		// create person
		persons = factory.createPerson();
		for (int i = 0; i < persons.size(); ++i)
			imagePanel.add(persons.get(i).lb);
		
		// create aircraft
		aircrafts = factory.createAircraft();
		for (int i = 0; i < aircrafts.size(); ++i)
			imagePanel.add(aircrafts.get(i).lb);
		
		// create destination
		destinations = factory.createDestination();
		for (int i = 0; i < destinations.size(); ++i) {
			imagePanel.add(destinations.get(i).lbSuccess);
			imagePanel.add(destinations.get(i).lbFail);
			destinations.get(i).lbSuccess.setVisible(false);
			destinations.get(i).lbFail.setVisible(false);
			imagePanel.add(destinations.get(i).lb);
		}
		
		// create disturbance
		disturbances = factory.createDisturbance();
		for (int i = 0; i < disturbances.size(); ++i)
			imagePanel.add(disturbances.get(i).lb);
		
		
		// set background
		bgImagePath = "https://i.imgur.com/pLHkh4G.jpg";
		setWindow(bgImagePath);
		
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
