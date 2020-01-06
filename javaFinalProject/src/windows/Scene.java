package windows;

import items.*;
import result.*;

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
	CompositeItem compositeItems = new CompositeItem();
	
	public SceneFactory factory;


	public Scene() {
		imagePanel = new JPanel();
		imagePanel.setSize(bgWidth, bgHeight);
		imagePanel.setLocation(0, 0);
		imagePanel.setLayout(null);
		
		wp = new WindowPainter(0, 0, 0, 0, 0, 0);
		wp.setLabelVisibility(true);
		imagePanel.add(wp.getLabel());
	}

	public void setWindow(String bgImagePath) {
		setBackground();
		setKeyListener();
		setCommand();
	}
	
	private void setBackground() {
		try {
			ImageIcon icon = new ImageIcon(new URL(bgImagePath));
			icon.setImage(icon.getImage().getScaledInstance(bgWidth, bgHeight, Image.SCALE_DEFAULT));
			JLabel lb = new JLabel(icon);
			imagePanel.add(lb);
			lb.setSize(bgWidth, bgHeight);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void setKeyListener() {
		imagePanel.setFocusable(true);
		imagePanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				WindowController.remoteController.pressButton(e.getKeyCode());
			}
		});
	}
	
	public void setCommand() {
		WindowController.remoteController.setRemoteController(KeyEvent.VK_DOWN, new JumpOffCommand(compositeItems.getElementsByClassInstance(Person.class)));
		WindowController.remoteController.setRemoteController(KeyEvent.VK_N, new NextStageCommand(this));
		WindowController.remoteController.setRemoteController(KeyEvent.VK_R, new ReplayCommand(this));
		WindowController.remoteController.setRemoteController(KeyEvent.VK_ENTER, new SkipStageCommand(this));
	}
	
	public void goToNextStage() {
		System.out.println("N pressed");
		if (isPassed == true) {
			prepareForStage(getNextStage());
		}
	}
	
	public void skipCurrentStage() {
		System.out.println("Enter pressed");
		prepareForStage(getNextStage());
	}
	
	public void replay() {
		System.out.println("R pressed");
		if (isPassed == false) {
			prepareForStage(getCurrentStage());
		}
	}
	
	private void prepareForStage(Scene scene) {
		timer.stop();
		imagePanel.removeAll();
		compositeItems.clear();
		WindowController.setStage(scene);
		isPassed = false;
		imagePanel.setFocusable(false);
	}
	
	public void addElementToPanel(SceneFactory factory) {
		createElement(factory);
		imagePanel = successLabel.addLabelToScreen(imagePanel);
		imagePanel = failureLabel.addLabelToScreen(imagePanel);
		imagePanel = compositeItems.addLabelToScreen(imagePanel);
	}
	
	private void createElement(SceneFactory factory) {
		compositeItems = factory.createPerson(compositeItems);
		compositeItems = factory.createAircraft(compositeItems);
		compositeItems = factory.createDisturbance(compositeItems);
		compositeItems = factory.createDestination(compositeItems);
	}
	
	public void startTimer() {
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void performAction() {
		wp.brush();
		compositeItems.move();
		compositeItems.effect(this);
	}

	public abstract Scene getCurrentStage();

	public abstract Scene getNextStage();
}