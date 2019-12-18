package items;

import windows.*;
import javax.swing.JPanel;

public abstract class Destination extends Items {
	private static final long serialVersionUID = 1L;
	
	private String imagePath = "https://i.imgur.com/rKpizPG.png";
	public JPanel nextStage;

	public Destination(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 250, 170, imagePath);
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
	
	@Override
	public void move() {
		
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.lb);
		return panel;
	}

//	public abstract void effect(ArrayList<Items> items, Scene currentScene);
}