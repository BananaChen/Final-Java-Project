package destination;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import items.Destination;
import items.Person;
import windows.Scene;
import windows.Stage4;

public class BlueMoon extends Destination implements ActionListener {

	int screenWidth = 1920;
	int screenHeight = 1000;

	public BlueMoon(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 400;
		imageHeight = 133;

		setImage(x, y, imageWidth, imageHeight, imagePath);
		/*
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/AcaNJHQ.png"));
			icon.setImage(icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
			lbSuccess = new JLabel(icon);
			lbSuccess.setSize(800, 600);
			lbSuccess.setLocation(550, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/v5S2iYS.png"));
			icon.setImage(icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
			lbFail = new JLabel(icon);
			lbFail.setSize(800, 600);
			lbFail.setLocation(550, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/

	}

	public void collideEvent() {
	}

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= 1250
					&& person.getPositionX() + person.imageWidth <= 1650
					&& person.getPositionY() + person.imageHeight >= 900
					&& person.getPositionY() + person.imageHeight <= 963) {
				lbSuccess.setVisible(true);
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);
			}
			// if not
			else if (person.isDropped && person.getPositionY() + person.imageHeight < 0
					|| person.getPositionY() > screenHeight || person.getPositionX() > screenWidth
					|| person.getPositionX() + person.imageWidth < 0) {

				curStage.timer.stop();
				lbFail.setVisible(true);
				person.setVisible(false);
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}