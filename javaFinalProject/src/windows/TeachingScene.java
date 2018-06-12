package windows;

import items.*;
import aircraft.*;
import destination.*;

import javax.swing.*;
import java.awt.event.*;

//import java.awt.event.KeyListener;
public class TeachingScene extends Scene implements ActionListener {

	public static Timer timer;

	public TeachingScene() {

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

		Destination destination = new TeachingIsland(500, 500, 1, 1, 1, 1);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		// imagePanel.addKeyListener(keyAdapter);

		// 設定window參數
		bgImagePath = "https://i.imgur.com/uJ3EP7b.jpg";
		setWindow(0, bgImagePath);

		// start timer
		timer.start();
	}

	@Override
	public Scene getNextStage() {
		return new Stage1();
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

}
