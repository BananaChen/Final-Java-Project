package items;

import windows.*;
//import items.*;

import java.beans.PersistenceDelegate;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import com.sun.prism.Image;

//import com.sun.webkit.event.WCChangeEvent;

public class Destination extends Items {

	private String imagePath = "https://i.imgur.com/rKpizPG.png";
	public JLabel lbSuccess;
	public JLabel lbFail;
	public JPanel nextStage;

	public Destination(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 250, 170, imagePath);

//		Image bg = ImageIO.
		
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/AcaNJHQ.png"));
			lbSuccess = new JLabel(icon);
			lbSuccess.setSize(600, 400);
			lbSuccess.setLocation(300, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/0Iha59i.png"));
			lbFail = new JLabel(icon);
			lbFail.setSize(600, 400);
			lbFail.setLocation(300, 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void collideEvent() {
	}
	public void effect() {
		
	}
	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (Math.acos(person.getPositionY() + 100 - this.positionY) < 50
					&& (person.getPositionX() - this.positionX < 600 && person.getPositionX() - this.positionX > 0)) {
				lbSuccess.setVisible(true);
				person.lb.setVisible(false);
				Scene.isPassed = true;
			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0) {
				lbFail.setVisible(true);
				person.lb.setVisible(false);
			}
		}
	}
}
