package windows;

import javax.swing.JFrame;

public class WindowController extends JFrame {

	public final static int NumOfStage = 6;
	public static boolean[] stageStatus = new boolean[NumOfStage];

	public static Scene stage;
	private static WindowController wc;
	private int bgWidth = Scene.bgWidth;
	private int bgHeight = Scene.bgHeight;

	public WindowController() {
		setSize(bgWidth, bgHeight);
		setTitle("Parachute Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public static void main(String[] args) {
		
		//init stage status
		for (int i = 0; i < NumOfStage; ++i) {
			stageStatus[i] = false;
		}

		wc = new WindowController();
		stage = new StartScene();
		stageStatus[0] = true;
		
		wc.add(stage.imagePanel);
		wc.setVisible(true);
	}

	public static void setStage(Scene nextStage) {
		stage = null;
		// wc.getContentPane().removeAll();
		stage = nextStage;
		wc.add(stage.imagePanel);
		wc.repaint();
		System.out.println(stage.getClass());
		}
};