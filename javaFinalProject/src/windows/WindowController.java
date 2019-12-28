package windows;

import javax.swing.JFrame;

import command.RemoteController;

public class WindowController extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public final static int NumOfStage = 6;
	public static boolean[] stageStatus = new boolean[NumOfStage];

	public static Scene stage;
	private static WindowController wc;
	private int bgWidth = Scene.bgWidth;
	private int bgHeight = Scene.bgHeight;
	
	static RemoteController remoteController = new RemoteController();

	public WindowController() {
		setSize(bgWidth, bgHeight);
		setTitle("Parachute Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public static void main(String[] args) {
		for (int i = 0; i < NumOfStage; ++i) {
			stageStatus[i] = false;
		}

		wc = new WindowController();
		stage = new StartScene();
		stage.setCommand(); // set up command
		stageStatus[0] = true;
		
		wc.add(stage.imagePanel);
		wc.setVisible(true);
	}

	public static void setStage(Scene nextStage) {
		stage = null;
		stage = nextStage;
		stage.setCommand(); // set up command
		wc.add(stage.imagePanel);
		wc.repaint();
		System.out.println(stage.getClass());
	}
};