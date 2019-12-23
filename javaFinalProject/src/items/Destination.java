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
		panel.add(this.getLabel());
		return panel;
	}
	
	public abstract boolean successfulLanding(Person person);
	public abstract boolean failedLanding(Person person);
	
	public void successHandler(Scene scene) {
		scene.successLabel.setLabelVisibility(true);
		scene.isPassed = true;
		scene.timer.stop();
	}
	
	public void failureHandler(Scene scene) {
		scene.failureLabel.setLabelVisibility(true);
		scene.timer.stop();
	}
	
	public void personActionAfterward(Person person) {
		person.setLabelVisibility(false);
		person.setAccelerationX(0);
		person.setAccelerationY(0);
		person.setVelocityX(0);
		person.setVelocityY(0);
	}

//	public abstract void effect(ArrayList<Items> items, Scene currentScene);
}