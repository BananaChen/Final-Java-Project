package disturbance;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import items.Disturbance;
import items.Person;
import windows.Stage2;

public class Arrow extends Disturbance implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2175622363441527169L;
	boolean isStop = false;
	int waitTime = 0;
	Timer timer;
	public Arrow(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 100;
		imageHeight = 100;
		timer = new Timer(9, this);
		setImage(x, y, imageWidth, imageHeight, imagePath);
		/*
		try {
			ImageIcon icon = new ImageIcon(new URL(a));
			icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
			lb = new JLabel(icon);
			lb.setLocation((int)x, (int)y);
			lb.setSize(100,100);
			lb.setLayout(null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/0Iha59i.png"));
			icon.setImage(icon.getImage().getScaledInstance(1200,900,Image.SCALE_DEFAULT));
			lbFail = new JLabel(icon);
			lbFail.setSize(1200,900);
			lbFail.setLocation(0,0);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		*/
		timer.start();
	}
	
	
	public void move() {
	}
	/*
	public void collideEvent() {
		
		
    }
*/
    public void effect(ArrayList<Person> persons) {
    	//if getting shoot
    	if ((this.positionX+100 > persons.get(0).getPositionX() && this.positionX+100 < persons.get(0).getPositionX()+100) && (this.positionY > persons.get(0).getPositionY() && this.positionY < persons.get(0).getPositionY()+100)) {
    		persons.get(0).positionX += 10;
    		//relocated
    		this.positionX = Math.random()*1200 - 600;
    	   	this.positionY = Math.random()*200 + 900;
    	   	this.lb.setLocation((int)this.positionX, (int)this.positionY);
    	   	isStop = true;
    	   	//set a random time to wait to restart
    	   	waitTime = (int) (Math.random()*100+1);
    		if (persons.get(0).isDropped)
    			persons.get(0).blood--;
    	}
    	
    	
    	//if out of bounds, relocated
    	if (this.positionY+100 < 0 || this.positionX > 1200) {
    		this.positionX = Math.random()*1200 - 600;
    		this.positionY = Math.random()*200 + 900;
    		this.lb.setLocation((int)this.positionX, (int)this.positionY);
    		isStop = true;
    		//set a random time to wait to restart
    		waitTime = (int) (Math.random()*100+1);
    	}
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		//restart or move
		if (isStop && waitTime > 0) {
			waitTime--;
			this.positionX = 0;
			this.positionY = 900;
			if (waitTime <= 0) { //restart
				isStop = false;
				this.positionX = Math.random()*1200 - 600;
	    		this.positionY = Math.random()*200 + 900;
			}
		}
		else {
			this.positionX += 15;
			this.positionY -= 15;
		}
		this.lb.setLocation((int)this.positionX, (int)this.positionY);
	}



}
