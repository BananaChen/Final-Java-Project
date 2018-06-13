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

public class Alien extends Person implements ActionListener {
	
	public Alien(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 137, "https://i.imgur.com/bg3surr.png");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}