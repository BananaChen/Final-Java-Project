package windows;

import items.*;
import person.Nigga;
import aircraft.*;
import destination.Island;
import disturbance.*;
import disturbance.Spring;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Stage1 extends Scene implements ActionListener {

	public static Timer timer;
	private double gravity = 0.5;
	private Disturbance bigfan, spring;

	public Stage1() {
		
		super();
		
		// Timer
		timer = new Timer(10, this);

		// 宣告Scene中的element
		Person person = new Person(0, 0, 0, 0, 0, 0);
		pvx = 1;
		pvy = 1;
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		Destination destination = new Island(500, 750, 0, 0, 0, 0);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		bigfan = new BigFan(0, 200, 0, 0, 0, 0);
		imagePanel.add(bigfan.lb);
		disturbances.add(bigfan);

		spring = new Spring(1700, 300, 0, 0, 0, 0);
		imagePanel.add(spring.lb);
		disturbances.add(spring);

		// key event
		//imagePanel.setFocusable(true);
		//this.imagePanel.addKeyListener(keyAdapter);

		// 設定window參數
		bgImagePath = "https://i.imgur.com/uJ3EP7b.jpg";
		setWindow(1, bgImagePath);

		// start timer
		timer.start();
	}

	@Override
	public Scene getNextStage() {
		return new Stage2();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
			destinations.get(i).effect(persons);

		}
	}

}
