package windows;

import items.*;
import person.Thug;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import aircraft.WindowPainter;
import command.*;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Scene implements ActionListener {

	protected JPanel imagePanel;
	protected String bgImagePath;
	public final static int bgWidth = 1920;
	public final static int bgHeight = 1000;

	public boolean isPassed = false;
	protected static boolean isPaused = false;
	public Timer timer;
	
	public WindowPainter wp;
	public ArrayList<Person> persons = new ArrayList<Person>();
	public ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
	public ArrayList<Destination> destinations = new ArrayList<Destination>();
	public ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();
	
	// factory method instance
	public SceneFactory factory;
	
	// command pattern instance
	RemoteController remoteController = new RemoteController();

	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		
		wp = new WindowPainter(0, 0, 0, 0, 0, 0);
		wp.lb.setVisible(true);
		imagePanel.add(wp.lb);
		
		remoteController.setRemoteController(KeyEvent.VK_DOWN, new JumpOffCommand());
		remoteController.setRemoteController(KeyEvent.VK_N, new NextStageCommand());
		remoteController.setRemoteController(KeyEvent.VK_R, new ReplayCommand());
		remoteController.setRemoteController(KeyEvent.VK_ENTER, new SkipStageCommand());
	}
	
	public Scene getInstance() {
		return Scene.this;
	}
	
	

	public void setWindow(String bgImagePath) {
		try {
			ImageIcon icon = new ImageIcon(new URL(bgImagePath));
			icon.setImage(icon.getImage().getScaledInstance(bgWidth, bgHeight, Image.SCALE_DEFAULT));
			JLabel lb = new JLabel(icon);
			imagePanel.add(lb);
			lb.setSize(bgWidth, bgHeight);
			// add(imagePanel);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// key event
		imagePanel.setFocusable(true);
		imagePanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				remoteController.pressButton(e.getKeyCode(), imagePanel, getInstance(), isPassed, timer, persons, aircrafts);
			}
		});
	}
	
	public void addElementToPanel(SceneFactory factory) {
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
	}
	
	public void startTimer() {
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void performAction(boolean initPersonSpeed) {
		wp.brush();
		for (int i = 0; i < persons.size(); ++i) {
			if (initPersonSpeed) {
				persons.get(i).personInitVx = aircrafts.get(i).getVelocityX();
				persons.get(i).personInitVy = aircrafts.get(i).getVelocityY();
			}
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
			destinations.get(i).effect(persons, this);
		}
	}

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}