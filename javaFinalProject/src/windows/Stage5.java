package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Stage5 extends Scene implements ActionListener {

	// Container c;
	public double bloodX;
	public double bloodY;

	public ArrayList<Disturbance> fireballs;

	public Stage5() {

		super();

		// Timer
		timer = new Timer(10, this);

		// declare elements in scene
		Destination island = new Home(600, 650, 1, 1, 1, 1);
		destinations.add(island);
		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		aircrafts = new ArrayList<Aircraft>();
		Aircraft roller1 = new RollerCoaster(900, 30, 0, 0, 247.5, 0);
		roller1.setImage(1, 1, 150, 150, "https://i.imgur.com/ggI5oOx.png");
		aircrafts.add(roller1);
		imagePanel.add(roller1.lb);
		Aircraft roller2 = new RollerCoaster(950, 100, 0, 0, 270, 0);
		roller2.setImage(1, 1, 100, 100, "https://i.imgur.com/zkSxHWX.png");
		aircrafts.add(roller2);
		imagePanel.add(roller2.lb);
		Aircraft roller3 = new RollerCoaster(1020, 100, 0, 0, 292.5, 0);
		roller3.setImage(1, 1, 100, 100, "https://i.imgur.com/kMty2NS.png");
		aircrafts.add(roller3);
		imagePanel.add(roller3.lb);
		Aircraft roller4 = new RollerCoaster(1090, 80, 0, 0, 315, 0);
		roller4.setImage(1, 1, 50, 70, "https://i.imgur.com/WNpfnuS.png");
		aircrafts.add(roller4);
		imagePanel.add(roller4.lb);
		Aircraft roller5 = new RollerCoaster(1130, 50, 0, 0, 337.5, 0);
		roller5.setImage(1, 1, 100, 100, "https://i.imgur.com/5FXCIEX.png");
		aircrafts.add(roller5);
		imagePanel.add(roller5.lb);
		Aircraft roller6 = new RollerCoaster(1180, 50, 0, 0, 360, 0);
		roller6.setImage(1, 1, 100, 100, "https://i.imgur.com/GFtcyKx.png");
		aircrafts.add(roller6);
		imagePanel.add(roller6.lb);
		
		Person person = new PokemonMaster(50, 50, 0, 0, 0, 0.01);
		person.lb.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lb);

		fireballs = new ArrayList<Disturbance>();
		for (int i = 0; i < 4; ++i) {
			fireballs.add(new FireBall(0, 700, 0, 0, 0, 0, "https://i.imgur.com/I9l1stq.png"));
			imagePanel.add(fireballs.get(i).lb);
		}

		// set window
		bgImagePath = "https://i.imgur.com/ntB2uDf.png";
		setWindow(bgImagePath);

		// start timer
		timer.start();
	}



	@Override
	public Scene getCurrentStage() {
		return new Stage5();
	}

	@Override
	public Scene getNextStage() {
		return new EndScene();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		wp.brush();
		for (int i = 0; i < persons.size(); ++i) {
			persons.get(i).move();
			persons.get(i).personInitVx = aircrafts.get(i).getVelocityX();
			persons.get(i).personInitVy = aircrafts.get(i).getVelocityY();
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
		for (int i = 0; i < fireballs.size(); ++i) {
			fireballs.get(i).effect(persons, aircrafts);
		}
	}
}