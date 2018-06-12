package windows;

import java.util.ArrayList;
import items.*;

import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Scene{

	protected JPanel imagePanel;
	protected String bgImagePath;
	protected int bgWide = 1920;
	protected int bgLength = 1000;

	// protected
	public static boolean isPassed = false;
	protected static boolean isPaused = false;
	protected Timer timer;
	protected double gravity;
	//clean these shit every time
	public ArrayList<Person> persons = new ArrayList<Person>();
	public ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
	public ArrayList<Destination> destinations = new ArrayList<Destination>();
	public ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();

	public double pvx;
	public double pvy;

	public Scene() {

	}

	public void setWindow(int stageNum, String bgImagePath) {
		/*
		 * setSize(bgWide, bgLength); setTitle("Stage" + stageNum);
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(null);
		 */
		/*
		imagePanel = new JPanel();
		imagePanel.setSize(bgWide, bgLength);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		*/
		try {
			ImageIcon icon = new ImageIcon(new URL(bgImagePath));
			JLabel lb = new JLabel(icon);
			imagePanel.add(lb);
			lb.setSize(bgWide, bgLength);
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
						System.out.println(person.getClass());
						if (person.isDropped == false) {
							System.out.println(1231231212);
							person.lb.setVisible(true);
							// person.setPositionX(aircrafts.get(0).getPositionX());
							// person.setPositionY(aircrafts.get(0).getPositionY());
							person.positionX = aircrafts.get(0).positionX + aircrafts.get(0).imageWidth / 2;
							person.positionY = aircrafts.get(0).positionY + aircrafts.get(0).imageHeight / 2;
							person.setVelocityX(0.5);
							person.setVelocityY(1);
							// person.setAccelerationY(gravity);
							person.lb.setLocation((int) person.getPositionX(), (int) person.getPositionY());
							person.isDropped = true;
						}
					}
					break;
				case KeyEvent.VK_N:
					if (isPassed == true) {
						WindowController.s2 = true;
						imagePanel.removeAll();
						WindowController.setStage(new Stage1());
						System.out.println("go to next stage");
						isPassed = false;
						imagePanel.setFocusable(false);
					}
					break;
				}
			}
		});
	}

	public abstract Scene getNextStage();
}
