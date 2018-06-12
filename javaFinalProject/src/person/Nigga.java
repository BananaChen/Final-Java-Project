package person;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import items.*;

public class Nigga extends Person implements ActionListener {

	private static final long serialVersionUID = -1233480500986673884L;
	// public String address;
	// public JLabel lb;

	public Nigga(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		timer = new Timer(10, this);
		// setImage(x, y, width, height,
		// "https://image.flaticon.com/icons/png/512/72/72924.png");

		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/uSpGrlw.png"));
			icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			lbThugLife = new JLabel(icon);
			lbThugLife.setLocation((int) 0, (int) 0);
			lbThugLife.setSize(100, 100);
			lbThugLife.setLayout(null);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// put on sunglasses
		if (gy > this.positionY + 10) {
			this.gy -= 2;
			lbThugLife.setLocation((int) this.gx, (int) this.gy);
		} else
			timer.stop();
	}
}
