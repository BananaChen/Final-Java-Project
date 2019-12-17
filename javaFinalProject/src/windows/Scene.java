package windows;

import items.*;
import person.Thug;

import java.util.ArrayList;

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
	public ArrayList<Items> persons = new ArrayList<Items>();
	public ArrayList<Items> aircrafts = new ArrayList<Items>();
	public ArrayList<Items> destinations = new ArrayList<Items>();
	public ArrayList<Items> disturbances = new ArrayList<Items>();
	
	// factory method instance
	public SceneFactory factory;
	
	

	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		
		wp = new WindowPainter(0, 0, 0, 0, 0, 0);
		wp.lb.setVisible(true);
		imagePanel.add(wp.lb);
		
		// set up commands
//		setCommand();
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
				WindowController.remoteController.pressButton(e.getKeyCode(), getInstance());
			}
		});
	}
	
	public void setCommand() {
		WindowController.remoteController.setRemoteController(KeyEvent.VK_DOWN, new JumpOffCommand());
		WindowController.remoteController.setRemoteController(KeyEvent.VK_N, new NextStageCommand());
		WindowController.remoteController.setRemoteController(KeyEvent.VK_R, new ReplayCommand());
		WindowController.remoteController.setRemoteController(KeyEvent.VK_ENTER, new SkipStageCommand());
	}
	
	public void goToNextStage() {
		System.out.println("N pressed");
		if (isPassed == true) {
			timer.stop();
			imagePanel.removeAll();
			// go to next stage
			WindowController.setStage(getNextStage());
			System.out.println("go to next stage");
			isPassed = false;
			imagePanel.setFocusable(false);
		}
	}
	
	public void skipToNextStage() {
		System.out.println("Enter pressed");
		timer.stop();
		imagePanel.removeAll();
		WindowController.setStage(getNextStage());
		isPassed = false;
		imagePanel.setFocusable(false);
	}
	
	public void replay() {
		System.out.println("R pressed");
		if (isPassed == false) {
			timer.stop();
			imagePanel.removeAll();
			// restart current stage
			WindowController.setStage(getCurrentStage());
			System.out.println("replay");
			isPassed = false;
			imagePanel.setFocusable(false);
		}
	}
	
	public void jumpOff() {
		System.out.println("Down pressed");
		for (int i = 0; i < persons.size(); ++i) {
			Person person = (Person) persons.get(i);
			if (person.isDropped == false) {
				person.lb.setVisible(true);
				person.personInitPx = aircrafts.get(i).positionX + aircrafts.get(i).imageWidth / 2;
				person.personInitPy = aircrafts.get(i).positionY + aircrafts.get(i).imageHeight / 2;
				person.setMoveData(person.personInitPx, person.personInitPy, person.personInitVx,
						person.personInitVy, person.personInitAx, person.personInitAy);
				person.lb.setLocation((int) person.getPositionX(), (int) person.getPositionY());
				person.isDropped = true;
			}
		}
	}
	
	public void addElementToPanel(SceneFactory factory) {
		// create person
		addPersonToPanel(factory);
		
		// create aircraft
		addAircraftToPanel(factory);
		
		// create destination
		addDestinationToPanel(factory);
		
		// create disturbance
		addDisturbanceToPanel(factory);
	}
	
	private void addPersonToPanel(SceneFactory factory) {
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
	}
	
	private void addAircraftToPanel(SceneFactory factory) {
		aircrafts = factory.createAircraft();
		for (int i = 0; i < aircrafts.size(); ++i)
			imagePanel.add(aircrafts.get(i).lb);
	}
	
	private void addDisturbanceToPanel(SceneFactory factory) {
		disturbances = factory.createDisturbance();
		for (int i = 0; i < disturbances.size(); ++i)
			imagePanel.add(disturbances.get(i).lb);
	}
	
	private void addDestinationToPanel(SceneFactory factory) {
		destinations = factory.createDestination();
		for (int i = 0; i < destinations.size(); ++i) {
			imagePanel.add(((Destination)destinations.get(i)).lbSuccess);
			imagePanel.add(((Destination)destinations.get(i)).lbFail);
			((Destination)destinations.get(i)).lbSuccess.setVisible(false);
			((Destination)destinations.get(i)).lbFail.setVisible(false);
			imagePanel.add(destinations.get(i).lb);
		}
	}
	
	public void startTimer() {
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void performAction(boolean initSpeed) {
		brushPanel();
		personAction(initSpeed);
		aircraftAction(initSpeed);
		disturbanceAction(initSpeed);
		destinationAction(initSpeed);
	}
	
	private void brushPanel() {
		wp.brush();
	}
	
	private void personAction(boolean initPersonSpeed) {
		for (int i = 0; i < persons.size(); ++i) {
			if (initPersonSpeed) {
				((Person)persons.get(i)).personInitVx = aircrafts.get(i).getVelocityX();
				((Person)persons.get(i)).personInitVy = aircrafts.get(i).getVelocityY();
			}
			persons.get(i).move();
		}
	}
	
	private void aircraftAction(boolean initAircraftSpeed) {
		for (int i = 0; i < aircrafts.size(); ++i) {
			aircrafts.get(i).move();
			if (aircrafts.get(i).getPositionX() > bgWidth) {
				aircrafts.get(i).setPositionX(-aircrafts.get(i).imageWidth);
			}
		}
	}
	
	private void disturbanceAction(boolean initDisturbanceSpeed) {
		for (int i = 0; i < disturbances.size(); ++i) {
			disturbances.get(i).effect(persons, this);
		}
	}
	
	private void destinationAction(boolean initDestinationSpeed) {
		for (int i = 0; i < destinations.size(); ++i) {
			destinations.get(i).effect(persons, this);
		}
	}

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}