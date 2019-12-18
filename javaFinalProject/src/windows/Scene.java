package windows;

import items.*;
import person.Thug;
import result.*;

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
	public Result successLabel = new Success(300, 200, 800, 400);
	public Result failureLabel = new Failure(300, 200, 800, 400);

	public Timer timer;
	
	public WindowPainter wp;
	public ArrayList<Items> persons;
	public ArrayList<Items> aircrafts;
	public ArrayList<Items> destinations;
	public ArrayList<Items> disturbances;
	CompositeItem compositeItems = new CompositeItem();
	
	// abstract factory method instance
	public SceneFactory factory;
	
	

	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		
		wp = new WindowPainter(0, 0, 0, 0, 0, 0);
		wp.lb.setVisible(true);
		imagePanel.add(wp.lb);
	}
	
	public Scene getInstance() {
		return Scene.this;
	}

	public void setWindow(String bgImagePath) {
		// add background
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
			compositeItems.clear();
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
		compositeItems.clear();
		WindowController.setStage(getNextStage());
		isPassed = false;
		imagePanel.setFocusable(false);
	}
	
	public void replay() {
		System.out.println("R pressed");
		if (isPassed == false) {
			timer.stop();
			imagePanel.removeAll();
			compositeItems.clear();
			// restart current stage
			WindowController.setStage(getCurrentStage());
			System.out.println("replay");
			isPassed = false;
			imagePanel.setFocusable(false);
		}
	}
	
	public void jumpOff() {
		System.out.println("Down pressed");
		if (compositeItems.isEmpty()) {
			return;
		}
		
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
		// create all elements
		createElement(factory);
		
		// add all elements to screen
		imagePanel = compositeItems.addLabelToScreen(imagePanel);
		imagePanel = successLabel.addLabelToScreen(imagePanel);
		imagePanel = failureLabel.addLabelToScreen(imagePanel);
	}
	
	private void createElement(SceneFactory factory) {
		// create person
		createPerson(factory);
		
		// create aircraft
		createAircraft(factory);
		
		// create destination
		createDisturbance(factory);
		
		// create disturbance
		createDestination(factory);
	}
	
	private void createPerson(SceneFactory factory) {
		compositeItems = factory.createPerson(compositeItems);
		persons = compositeItems.getElementsByClassInstance(Person.class);
	}
	
	private void createAircraft(SceneFactory factory) {
		compositeItems = factory.createAircraft(compositeItems);
		aircrafts = compositeItems.getElementsByClassInstance(Aircraft.class);
	}
	
	private void createDisturbance(SceneFactory factory) {
		compositeItems = factory.createDisturbance(compositeItems);
		disturbances = compositeItems.getElementsByClassInstance(Disturbance.class);
	}
	
	private void createDestination(SceneFactory factory) {
		compositeItems = factory.createDestination(compositeItems);
		destinations = compositeItems.getElementsByClassInstance(Destination.class);
	}
	
	public void startTimer() {
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void performAction(boolean initSpeed) {
		brushPanel();
		compositeItems.move();
//		compositeItems.effect(this);
		compositeItems.effect(persons, this);
	}
	
	private void brushPanel() {
		wp.brush();
	}
	
	public void successHandler() {
		successLabel.setLabelVisibility(true);
		isPassed = true;
		timer.stop();
	}
	
	public void failureHandler() {
		failureLabel.setLabelVisibility(true);
		timer.stop();
	}

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}