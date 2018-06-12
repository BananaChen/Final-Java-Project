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

	// protected
	public static boolean isPassed = false;
	protected static boolean isPaused = false;
	public Timer timer;
	protected double gravity;
	// clean these shit every time
	public ArrayList<Person> persons = new ArrayList<Person>();
	public ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
	public ArrayList<Destination> destinations = new ArrayList<Destination>();
	public ArrayList<Disturbance> disturbances = new ArrayList<Disturbance>();

	public double pvx = 0;
	public double pvy = 0;
	public double pax = 0;
	public double pay = 0;

	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
	}

	public void setWindow(int stageNum, String bgImagePath) {
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
						System.out.println(person.getClass());
						if (person.isDropped == false) {
							System.out.println(1231231212);
							person.lb.setVisible(true);
							person.positionX = aircrafts.get(0).positionX + aircrafts.get(0).imageWidth / 2;
							person.positionY = aircrafts.get(0).positionY + aircrafts.get(0).imageHeight / 2;
							person.setVelocityX(pvx);
							person.setVelocityY(pvy);
							person.setAccelerationX(pax);
							person.setAccelerationX(pay);
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
						/*
						 if(WindowController.stageStatus[0] == true) { 
						 	WindowController.setStage(new TeachingScene()); 
						 }*/
						 if (WindowController.stageStatus[1] == true) {
							WindowController.setStage(new Stage1());
						} else if (WindowController.stageStatus[2] == true) {
							WindowController.setStage(new Stage2());
						} else if (WindowController.stageStatus[3] == true) {
							// WindowController.setStage(new Stage3());
						} else if (WindowController.stageStatus[4] == true) {
							// WindowController.setStage(new Stage4());
						} else if (WindowController.stageStatus[1] == true) {
							// WindowController.setStage(new Stage5());
						}
						System.out.println("go to next stage");
						isPassed = false;
						imagePanel.setFocusable(false);
					}
					break;
				case KeyEvent.VK_R:
			          if (isPassed == false) {
			            imagePanel.removeAll();
			            if(WindowController.stageStatus[0] == true) {
			              WindowController.setStage(new TeachingScene());
			            }
			            else if(WindowController.stageStatus[1] == true) {
			              WindowController.setStage(new Stage1());
			            }
			            else if(WindowController.stageStatus[2] == true) {
			              WindowController.setStage(new Stage2());
			            }
			            else if(WindowController.stageStatus[3] == true) {
			              //WindowController.setStage(new Stage3());
			            }
			            else if(WindowController.stageStatus[4] == true) {
			              //WindowController.setStage(new Stage4());
			            }
			            else if(WindowController.stageStatus[1] == true) {
			              //WindowController.setStage(new Stage5());
			            }
			            System.out.println("replay");
			            imagePanel.setFocusable(false);
			          }
			          break;
				}
			}
		});
	}

	public abstract Scene getNextStage();
}
