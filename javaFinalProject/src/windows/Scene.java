package windows;

import items.*;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Scene {

	protected JPanel imagePanel;
	protected String bgImagePath;
	protected static int bgWidth = 1920;
	protected static int bgHeight = 1000;

	public static boolean isPassed = false;
	protected static boolean isPaused = false;
	public Timer timer;
	protected double gravity;

	public ArrayList<Person> persons = new ArrayList<Person>();
	public ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
	public ArrayList<Destination> destinations = new ArrayList<Destination>();
	public ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();

	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
	}

	public void setWindow(String bgImagePath) {
		try {
			ImageIcon icon = new ImageIcon(new URL(bgImagePath));
			JLabel lb = new JLabel(icon);
			imagePanel.add(lb);
			lb.setSize(bgWidth, bgHeight);
			// add(imagePanel);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		imagePanel.setFocusable(true);
		// key event
		imagePanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					for (int i = 0; i < persons.size(); ++i) {
						Person person = persons.get(i);
						if (person.isDropped == false) {
							person.lb.setVisible(true);
							person.personInitPx = aircrafts.get(0).positionX + aircrafts.get(0).imageWidth / 2;
							person.personInitPy = aircrafts.get(0).positionY + aircrafts.get(0).imageHeight / 2;
							person.setMoveData(person.personInitPx, person.personInitPy, person.personInitVy, person.personInitVy, person.personInitAx, person.personInitAy);
							person.lb.setLocation((int) person.getPositionX(), (int) person.getPositionY());
							person.isDropped = true;
						}
					}
					break;
				case KeyEvent.VK_N:
					for (int i = 0; i < WindowController.NumOfStage; ++i) {
						System.out.print(WindowController.stageStatus[i] + " ");
					}
					System.out.println(" ");
					if (isPassed == true) {
						imagePanel.removeAll();
						//go to next stage
						WindowController.setStage(getNextStage());
						System.out.println("go to next stage");
						isPassed = false;
						imagePanel.setFocusable(false);
					}
					break;
				case KeyEvent.VK_R:
					if (isPassed == false) {
						imagePanel.removeAll();
						//restart current stage
						WindowController.setStage(getCurrentStage());
						System.out.println("replay");
						isPassed = false;
						imagePanel.setFocusable(false);
					}
					break;
				}
			}
		});
	}

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}
