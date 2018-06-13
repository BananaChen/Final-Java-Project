package person;

import items.*;

public class Turtle extends Person {
	private String imagePath = "https://i.imgur.com/A05MTnq.gif";

    public Turtle(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
        super(x, y, vx, vy, ax, ay);
        setImage(x, y, 100, 100, imagePath);
    }

    @Override
    public void move() {
        this.velocityX += this.accelerationX;
        this.velocityY += this.accelerationY;
        this.positionX += this.velocityX;
        this.positionY += this.velocityY;
        this.lb.setLocation((int)this.positionX, (int)this.positionY);
    }

    public void collideIsland() {
        setVelocityX(0);
        setVelocityY(0);
        setAccelerationX(0);
        setAccelerationY(0);
    }
    public void collideOcean() {
        setVelocityX(0);
        setVelocityY(0);
        setAccelerationX(0);
        setAccelerationY(0);
    }

    @Override


    
    public void effect() {

    }

}
