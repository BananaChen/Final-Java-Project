package windows;

import items.*;
import aircraft.*;
import disturbance.BigFan;
import disturbance.Spring;
import guy.PokemonMaster;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TeachingScene extends Scene implements ActionListener {

	public TeachingScene() {
		// Timer
		Timer timer = new Timer(10, this);

		// �ŧiScene����element
		persons = new ArrayList<Person>();
		Person person = new PokemonMaster(0, 0, 0, 1, 0, 0);
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		aircrafts = new ArrayList<Aircraft>();
		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		destinations = new ArrayList<Destination>();
		Destination destination = new Destination(500, 500, 1, 1, 1, 1);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		// key event
		imagePanel.setFocusable(true);
		this.imagePanel.addKeyListener(keyAdapter);

		// �]�wwindow�Ѽ�
		bgImagePath = "https://i.imgur.com/uJ3EP7b.jpg";
		setWindow(0, bgImagePath);

		// start timer
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for (int i = 0; i < persons.size(); ++i) {
			persons.get(i).move();
		}
		for (int i = 0; i < aircrafts.size(); ++i) {
			aircrafts.get(i).move();
		}
		for (int i = 0; i < destinations.size(); ++i) {
			destinations.get(i).effect(persons);
		}
	}

	@Override
	public Scene getNextStage() {
		return new Stage1();
	}

}
