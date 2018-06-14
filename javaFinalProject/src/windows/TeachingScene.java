package windows;

import items.*;
import aircraft.*;
import destination.*;

import javax.swing.*;
import java.awt.event.*;

public class TeachingScene extends Scene implements ActionListener {

	public TeachingScene() {

		super();

		timer = new Timer(10, this);

		// declare elements in scene
		Person person = new Person(0, 0, 1, 1, 0, 0);
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		Destination destination = new Island(1000, 500, 1, 1, 1, 1);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		// set window
		bgImagePath = "https://i.imgur.com/BDmnRVK.jpg";
		setWindow(bgImagePath);

		// start timer
		timer.start();
	}

	@Override
	public Scene getCurrentStage() {
		return new TeachingScene();
	}

	@Override
	public Scene getNextStage() {
		return new Stage1();
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
	}

}