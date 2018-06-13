package windows;

import items.*;
import aircraft.*;
import disturbance.*;
import disturbance.Spring;
import guy.PokemonMaster;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stage5 extends Scene implements ActionListener {


	private static final long serialVersionUID = -4016908006671905398L;
	
	
	
	
	public static Timer timer;
	
	Container c;
	double bloodX; 
	double bloodY;
	
	public ArrayList<Disturbance> fireballs;
	
	
	public Stage5() {
		// Timer
		Timer timer = new Timer(10, this);

		// �ŧiScene����element
		persons = new ArrayList<Person>();
		Person person = new PokemonMaster(50, 50, 0, 0, 0, 0);
		pvx = 0.5;
		person.lb.setVisible(false);
		person.lbThugLife.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lbThugLife);
		imagePanel.add(persons.get(0).lb);

		aircrafts = new ArrayList<Aircraft>();
		Aircraft roller1 = new RollerCoaster(900 , 30 , 0, 0, 247.5, 0);
		roller1.setImage(1, 1, 150, 150, "https://i.imgur.com/ggI5oOx.png");
		aircrafts.add(roller1);
		imagePanel.add(roller1.lb);
		Aircraft roller2 = new RollerCoaster(950 , 100, 0, 0, 270, 0);
		roller2.setImage(1, 1, 100, 100, "https://i.imgur.com/zkSxHWX.png");
		aircrafts.add(roller2);
		imagePanel.add(roller2.lb);
		Aircraft roller3 = new RollerCoaster(1020 , 100, 0, 0, 292.5, 0);
		roller3.setImage(1, 1, 100, 100, "https://i.imgur.com/kMty2NS.png");
		aircrafts.add(roller3);
		imagePanel.add(roller3.lb);
		Aircraft roller4 = new RollerCoaster(1090 , 80, 0, 0, 315, 0);
		roller4.setImage(1, 1, 50, 70, "https://i.imgur.com/WNpfnuS.png");
		aircrafts.add(roller4);
		imagePanel.add(roller4.lb);
		Aircraft roller5 = new RollerCoaster(1130 , 50, 0, 0, 337.5, 0);
		roller5.setImage(1, 1, 100, 100, "https://i.imgur.com/5FXCIEX.png");
		aircrafts.add(roller5);
		imagePanel.add(roller5.lb);
		Aircraft roller6 = new RollerCoaster(1180 , 50, 0, 0, 360, 0);
		roller6.setImage(1, 1, 100, 100, "https://i.imgur.com/GFtcyKx.png");
		aircrafts.add(roller6);
		imagePanel.add(roller6.lb);
		
		
		fireballs = new ArrayList<Disturbance>();
	    for (int i = 0; i < 4; ++i) {
	    		fireballs.add(new FireBall(aircrafts.get(0).getPositionX(), aircrafts.get(0).getPositionY(), 0, 0, 0, 0, "https://i.imgur.com/I9l1stq.png"));
	    	imagePanel.add(fireballs.get(i).lb);
	    }
		
		
		destinations = new ArrayList<Destination>();
		Destination destination = new Destination(500, 500, 1, 1, 1, 1);
		destinations.add(destination);

		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		

		// key event
		//imagePanel.setFocusable(true);
		//this.imagePanel.addKeyListener( KeyBoy());

		// �]�wwindow�Ѽ�
		bgImagePath = "https://i.imgur.com/uJ3EP7b.jpg";
		setWindow(1, bgImagePath);

		// start timer
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		if (persons.get(0).isDropped)
			g.fillRect((int)bloodX, (int)bloodY, persons.get(0).blood*30, 5);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    for (int i = 0; i < persons.size(); ++i) {
	        persons.get(i).move();
	        //stick the blood to person
	        bloodX = (int) persons.get(i).getPositionX() + 10;
	        bloodY = (int) persons.get(i).getPositionY() + 10;
		    repaint();
	    }
	    for (int i = 0; i < aircrafts.size(); ++i) {
	        aircrafts.get(i).move();
	    }
	    for (int i = 0; i < destinations.size(); ++i) {
	    		disturbances.get(i).effect(persons);
	    }
	    for (int i = 0; i < fireballs.size(); ++i) {
	        fireballs.get(i).effect();
	    }
	    
	}

	public Scene getNextStage() {
		return new Stage1();
	}
}

