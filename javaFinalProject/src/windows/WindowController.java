package windows;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import items.Person;

public class WindowController extends JFrame {

	public final static int NumOfStage = 6;
	public static boolean[] stageStatus = new boolean[NumOfStage];

	private static WindowController wc;
	public static Scene stage;
	protected int bgWidth = Scene.bgWidth;
	protected int bgHeight = Scene.bgHeight;

	public WindowController() {
		setSize(bgWidth, bgHeight);
		setTitle("Java Final Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public static void main(String[] args) {

		for (int i = 0; i < NumOfStage; ++i) {
			stageStatus[i] = false;
		}

		wc = new WindowController();
		stage = new TeachingScene();
		stageStatus[0] = true;
		// setStage(new TeachingScene());
		wc.add(stage.imagePanel);

		wc.setVisible(true);
	}

	public static void setStage(Scene nextStage) {
		stage = null;
		// stage = nextStage;
		// wc.getContentPane().removeAll();
		Scene newStage = nextStage;
		wc.add(newStage.imagePanel);

		// stage = stage.getNextStage();
		wc.repaint();
		System.out.println(newStage.getClass());

		// stage.imagePanel.setFocusable(true);
		Scene.isPassed = false;
	}


};
