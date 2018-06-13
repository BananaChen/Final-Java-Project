package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

import javax.swing.*;
import java.awt.event.*;

public class Stage4 extends Scene implements ActionListener {

	private BlackHole1 blackhole1;
	private BlackHole2 blackhole2;
	private Planet1 planet1;
	private Magnetic1 magnetic1;
	private Magnetic2 magnetic2;
	private Magnetic3 magnetic3;

	public Stage4() {
		
		super();
		// Timer
		timer = new Timer(10, this);

		// declare elements in scene
		Person person = new Alien(10, 10, 0, 0, 0, 0);
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		Aircraft aircraft = new UFO(30, 20, 10, 0, 0, 0,"https://i.imgur.com/4G0ZiGK.gif");
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		Destination destination = new BlueMoon(1200, 830, 1, 1, 1, 1, "https://i.imgur.com/91LhC53.png");
		destinations.add(destination);
		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		//set disturbance

		blackhole1 = new BlackHole1(850, 600, 0, 0, 0, 0);
		imagePanel.add(blackhole1.lb);
		disturbances.add(blackhole1);
		
		blackhole2 = new BlackHole2(1650, 300, 0, 0, 0, 0);
		imagePanel.add(blackhole2.lb);
		disturbances.add(blackhole2);
		
		magnetic1 = new Magnetic1(0, 300, 0, 0, 0, 0);
		imagePanel.add(magnetic1.lb);
		disturbances.add(magnetic1);
		
		magnetic2 = new Magnetic2(600, 800, 0, 0, 0, 0);
		imagePanel.add(magnetic2.lb);
		disturbances.add(magnetic2);
		
		magnetic3 = new Magnetic3(1720, 500, 0, 0, 0, 0);
		imagePanel.add(magnetic3.lb);
		disturbances.add(magnetic3);
		
		planet1 = new Planet1(1000, 150, 0, 0, 0, 0);
		imagePanel.add(planet1.lb);
		disturbances.add(planet1);
		
		// set background
		bgImagePath = "https://i.imgur.com/jrWlbHA.jpg";
		setWindow(bgImagePath);
		
		// start timer
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		wp.brush();
		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			person.personInitVx = aircrafts.get(0).getVelocityX();
			person.personInitVy = aircrafts.get(0).getVelocityY();
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
		return new Stage4();
	}

	@Override
	public Scene getNextStage() {
		return new Stage5();
	}

}
