package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;


public class Stage2 extends Scene implements ActionListener {

	//Container c;
	public double bloodX;
	public double bloodY;
	
	public ArrayList<Disturbance> arrows;

	public Stage2() {
		super();
		
		// Timer
		timer = new Timer(10, this);

		// declare concrete factory
		factory = new Stage2Factory();
		
		// create person
		persons = factory.createPerson();
		for (int i = 0; i < persons.size(); ++i) {
			if (persons.get(i) instanceof Thug) {
				imagePanel.add(((Thug)persons.get(i)).lbSunGlasses);
				imagePanel.add(((Thug)persons.get(i)).heart1);
				imagePanel.add(((Thug)persons.get(i)).heart2);
				imagePanel.add(((Thug)persons.get(i)).heart3);
			}
			
			imagePanel.add(persons.get(i).lb);
		}
		
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
		bgImagePath = "https://i.imgur.com/dbcQwI3.jpg";
		setWindow(bgImagePath);
		
		// start timer
		timer.start();
	}

	
	@Override
	public Scene getCurrentStage() {
		return new Stage2();
	}

	@Override
	public Scene getNextStage() {
		return new Stage3();
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
		for (int i = 0; i < destinations.size(); ++i) {
			destinations.get(i).effect(persons, this);
		}
		for (int i = 0; i < disturbances.size(); ++i) {
			disturbances.get(i).effect(persons);
		}
	}

}
