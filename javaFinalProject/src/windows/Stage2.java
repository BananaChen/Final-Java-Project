package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stage2 extends Scene implements ActionListener {

	private static final long serialVersionUID = -4016908006671905398L;

	public static Timer timer;

	Container c;
	double bloodX;
	double bloodY;

	public ArrayList<Disturbance> arrows;

	public Stage2() {

		super();
		// contentPane
		// c = getContentPane();
		// Timer
		timer = new Timer(10, this);

		// 宣告Scene中的element
		Destination honeycomb = new Honeycomb(600, 700, 1, 1, 1, 1, "https://i.imgur.com/kYP2ZRC.png");
		destinations.add(honeycomb);
		imagePanel.add(destinations.get(0).lbSuccess);
		imagePanel.add(destinations.get(0).lbFail);
		destinations.get(0).lbSuccess.setVisible(false);
		destinations.get(0).lbFail.setVisible(false);
		imagePanel.add(destinations.get(0).lb);

		arrows = new ArrayList<Disturbance>();
		// Disturbance arrow = new Arrow(0, 700, 0, 0, 0, 0,
		// "https://i.imgur.com/Gm12azv.jpg");
		for (int i = 0; i < 2; ++i) {
			arrows.add(new Arrow(0, 700, 0, 0, 0, 0, "https://i.imgur.com/rhhmCwP.png"));
			imagePanel.add(arrows.get(i).lb);
		}

		Person person = new Nigga(50, 50, 0, 0, 0, 0);
		pvx = 0.5;
		pvy = 1;
		// person.setImage(x, y, wide, length, imagePath);
		person.lb.setVisible(false);
		person.lbThugLife.setVisible(false);
		persons.add(person);
		imagePanel.add(persons.get(0).lbThugLife);
		imagePanel.add(persons.get(0).lb);

		Aircraft bee = new Bee(0, 50, 0, 0, 0.1, 0.1, "https://i.imgur.com/kE4cmKB.png");
		aircrafts.add(bee);
		imagePanel.add(aircrafts.get(0).lb);

		/*
		 * imagePanel.setFocusable(true); //key event imagePanel.addKeyListener(new
		 * KeyAdapter() { public void keyPressed(KeyEvent e) {
		 * 
		 * switch (e.getKeyCode()) { case KeyEvent.VK_DOWN:
		 * System.out.println(1231231212); for (int i = 0; i < persons.size(); ++i) {
		 * Person person = persons.get(i); if (person.isDropped == false) {
		 * person.lb.setVisible(true); //
		 * person.setPositionX(aircrafts.get(0).getPositionX()); //
		 * person.setPositionY(aircrafts.get(0).getPositionY()); person.positionX =
		 * aircrafts.get(0).positionX + aircrafts.get(0).imageWidth / 2;
		 * person.positionY = aircrafts.get(0).positionY + aircrafts.get(0).imageHeight
		 * / 2; person.setVelocityX(pvx); person.setVelocityY(pvy); //
		 * person.setAccelerationY(gravity); person.lb.setLocation((int)
		 * person.getPositionX(), (int) person.getPositionY()); person.isDropped = true;
		 * } } break; case KeyEvent.VK_N: if (isPassed == true) { WindowController.s2 =
		 * true; WindowController.setStage(new Stage2());
		 * System.out.println("go to next stage"); } break; } } });
		 */
		/*
		 * 
		 * imagePanel.setFocusable(true); this.imagePanel.addKeyListener(new
		 * KeyAdapter() { public void keyPressed(KeyEvent e) { if (isdropped == false){
		 * switch(e.getKeyCode()) { case KeyEvent.VK_SPACE: //press SPACE to release
		 * person persons.get(0).lb.setVisible(true); persons.get(0).velocityX = 0.5;
		 * persons.get(0).velocityY = 1; persons.get(0).positionX =
		 * aircrafts.get(0).positionX; persons.get(0).positionY =
		 * aircrafts.get(0).positionY;
		 * persons.get(0).lb.setLocation((int)persons.get(0).getPositionX(),
		 * (int)persons.get(0).getPositionY()); isdropped = true; break; } } } });
		 */
		// 設定window參數
		setWindow(2, "https://i.imgur.com/uJ3EP7b.jpg");

		// start timer
		timer.start();
	}

	/// *
	// paint the blood
	public void paint(Graphics g) {
		// super.paint(g);
		g.setColor(Color.red);
		if (persons.get(0).isDropped)
			g.fillRect((int) bloodX, (int) bloodY, persons.get(0).blood * 30, 5);
	}
	// */

	@Override
	public Scene getNextStage() {
		return new Stage1();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < persons.size(); ++i) {
			persons.get(i).move();
			// stick the blood to person
			bloodX = persons.get(i).positionX + 10;
			bloodY = persons.get(i).positionY + 10;
			// repaint();
		}
		for (int i = 0; i < aircrafts.size(); ++i) {
			aircrafts.get(i).move();
			if (aircrafts.get(i).getPositionX() > bgWidth) {
				aircrafts.get(i).setPositionX(-aircrafts.get(i).imageWidth);
			}
		}
		for (int i = 0; i < destinations.size(); ++i) {
			destinations.get(i).effect(persons);
		}
		for (int i = 0; i < arrows.size(); ++i) {
			// arrows.get(i).collideEvent();
			arrows.get(i).effect(persons);
		}

	}
}
