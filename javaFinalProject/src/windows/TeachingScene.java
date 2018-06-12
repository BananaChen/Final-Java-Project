package windows;

import items.*;
import aircraft.*;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
public class TeachingScene extends Scene implements ActionListener {

	public TeachingScene() {
		
		imagePanel = new JPanel();
		imagePanel.setSize(bgWide, bgLength);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		
		// Timer
		Timer timer = new Timer(10, this);

		// 宣告Scene中的element
		//persons = new ArrayList<Person>();
		Person person = new Person(0, 0, 0, 0, 0, 0);
		pvx = 1;
		pvy = 1;
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		//aircrafts = new ArrayList<Aircraft>();
		Aircraft aircraft = new AirPlane(0, 0, 2, 0, 0, 0);
		aircrafts.add(aircraft);
		imagePanel.add(aircraft.lb);

		//destinations = new ArrayList<Destination>();
		Destination destination = new Destination(500, 500, 1, 1, 1, 1);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);
		
		
		
		//imagePanel.addKeyListener(keyAdapter);

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
