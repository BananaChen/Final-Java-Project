package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Stage2 extends Scene implements ActionListener {

	//Container c;
	public double bloodX;
	public double bloodY;
	
	public ArrayList<Disturbance> arrows;

	public Stage2() {

		super();
		// contentPane
		// c = getContentPane();
		
		
		// Timer
		timer = new Timer(10, this);

		
		
		// declare elements in scene
		//person
		Person person = new Nigga(50, 50, 0.5, 1, 0, 0);
		person.lb.setVisible(false);
		person.lbThugLife.setVisible(false);
		person.heart1.setVisible(false);
		person.heart2.setVisible(false);
		person.heart3.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lbThugLife);
		imagePanel.add(persons.get(0).heart1);
		imagePanel.add(persons.get(0).heart2);
		imagePanel.add(persons.get(0).heart3);
		imagePanel.add(persons.get(0).lb);
		
		
		Destination honeycomb = new Honeycomb(700, 500, 1, 1, 1, 1, "https://i.imgur.com/LqQXJuJ.png");
		destinations.add(honeycomb);
		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		//disturbance
		arrows = new ArrayList<Disturbance>();
		// Disturbance arrow = new Arrow(0, 700, 0, 0, 0, 0,
		// "https://i.imgur.com/Gm12azv.jpg");
		for (int i = 0; i < 2; ++i) {
			arrows.add(new Arrow(0, 700, 0, 0, 0, 0, "https://i.imgur.com/rhhmCwP.png"));
			imagePanel.add(arrows.get(i).lb);
		}

		//aircraft
		Aircraft bee = new Bee(0, 50, 0, 0, 0.1, 0.1, "https://i.imgur.com/kE4cmKB.png");
		aircrafts.add(bee);
		imagePanel.add(aircrafts.get(0).lb);

		// set background
		bgImagePath = "https://i.imgur.com/dbcQwI3.jpg";
		setWindow(bgImagePath);

		// start timer
		timer.start();
	}

	/// *
	// paint the blood
	public void paint(Graphics g) {
		//super.paint(g);
		g.setColor(Color.red);
		if (persons.get(0).isDropped)
			g.fillRect((int) bloodX, (int) bloodY, persons.get(0).blood * 30, 5);
	}
	// */
	
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
			// stick the blood to person
			bloodX = persons.get(i).positionX + 10;
			bloodY = persons.get(i).positionY + 10;
			// repaint();
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
		for (int i = 0; i < arrows.size(); ++i) {
			// arrows.get(i).collideEvent();
			arrows.get(i).effect(persons);
		}
	}
}
