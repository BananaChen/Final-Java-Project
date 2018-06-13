package destination;

import windows.*;

import java.awt.Image;
import java.beans.PersistenceDelegate;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import items.*;

public class Flower extends Destination {

	public static boolean isShooted = false;
	
	public Flower(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		setImage(x, y, 200, 300, imagePath);

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/AcaNJHQ.png"));
			icon.setImage(icon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
			lbSuccess = new JLabel(icon);
			lbSuccess.setSize(600, 400);
			lbSuccess.setLocation(300, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/v5S2iYS.png"));
			icon.setImage(icon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
			lbFail = new JLabel(icon);
			lbFail.setSize(600, 400);
			lbFail.setLocation(0, 500);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	
	public void effect(ArrayList<Person> persons, Scene curStage) {
		Person person = persons.get(0);
		if (person.getPositionX() + person.labelWide > this.positionX
				&& person.getPositionX() < (this.positionX + this.imageWidth)
				&& (person.getPositionY() + person.labelLength) > this.positionY
				&& person.getPositionY() < this.positionY + this.imageHeight) {
			person.setVelocityY(-10);
			this.lb.setVisible(false);
			isShooted = true;
			lbSuccess.setVisible(true);
			
			curStage.timer.stop();
			setNextStageStatus(curStage);
			
		} else if (person.getPositionY() > 800 && isShooted == false) {
			lbFail.setVisible(true);
			person.setVelocityY(0);
			person.setAccelerationY(0);
			// person.lb.setVisible(false);
		}
	}
}
