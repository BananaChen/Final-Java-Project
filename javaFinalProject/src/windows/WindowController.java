package windows;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowController extends JFrame{
	
	public static boolean s1, s2;

	private static WindowController wc;
	public static Scene stage;
//	protected JPanel imagePanel = new JPanel();
//	protected String bgImagePath;
	protected int bgWide = 1920;
	protected int bgLength = 1000;

	public WindowController() {
		setSize(bgWide, bgLength);
		setTitle("Java Final Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public static void main(String[] args) {

		wc = new WindowController();
		stage = new TeachingScene();
//		setStage(new TeachingScene());
		wc.add(stage.imagePanel);
		
		wc.setVisible(true);
		//stage.imagePanel.addKeyListener(wcKeyAdapter);
		//stage.imagePanel.setFocusable(true);
	}

	public static void setStage(Scene nextStage) {
		stage = null;
		//stage = nextStage;
		//wc.getContentPane().removeAll();
		Scene newStage = nextStage;
		wc.add(newStage.imagePanel);
		
		//stage = stage.getNextStage();
		wc.repaint();
		System.out.println(newStage.getClass());
		
		//stage.imagePanel.setFocusable(true);
		Scene.isPassed = false;
	}
	
};

