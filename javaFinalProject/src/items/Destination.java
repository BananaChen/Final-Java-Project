package items;

import windows.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Destination extends Items {

	private String imagePath = "https://i.imgur.com/rKpizPG.png";
	public JLabel lbSuccess;
	public JLabel lbFail;
	public JPanel nextStage;

	public Destination(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 250, 170, imagePath);

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/kGYlNur.png"));
			lbSuccess = new JLabel(icon);
			lbSuccess.setSize(800, 400);
			lbSuccess.setLocation(300, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/tLmAE6s.png"));
			lbFail = new JLabel(icon);
			lbFail.setSize(800
					, 400);
			lbFail.setLocation(300, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void setNextStageStatus(Scene curStage) {
		if (curStage.isPassed) {
			for (int j = 0; j < WindowController.NumOfStage; ++j) {
				if (WindowController.stageStatus[j] == true) {
					WindowController.stageStatus[j] = false;
					WindowController.stageStatus[j + 1] = true;
					break;
				}
			}
		}
	}

	public abstract void effect(ArrayList<Person> persons, Scene curStage);
}