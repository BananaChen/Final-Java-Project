package windows;

import items.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import aircraft.WindowPainter;
import command.*;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Scene {

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

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}