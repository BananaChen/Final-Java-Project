package aircraft;


import java.util.Random;

import items.Aircraft;


public class UFO extends Aircraft {

	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private int nextPositionX = 0;
	private int nextPositionY = 0;
	private boolean isMoveable = true;
	private int readyToStop = 0;
	
	public UFO(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 160;
		imageHeight = 186;
		setImage(0, 0, imageWidth, imageHeight, imagePath);
	}

	@Override
	public void move() {
		if(isMoveable) {
			//get the next position
			if(readyToStop == 0) {
				nextPositionX = random.nextInt(900)+30;
				nextPositionY = random.nextInt(2)+1;
				
				if(nextPositionY == 1) {
					nextPositionY = 20;
				}
				else if(nextPositionY == 2) {
					nextPositionY = 150;
				}
				this.setVelocityX(10*(nextPositionX - this.getPositionX())/Math.sqrt((nextPositionX - this.getPositionX())*(nextPositionX - this.getPositionX())+(nextPositionY - this.getPositionY())*(nextPositionY - this.getPositionY())));
				this.setVelocityY(10*(nextPositionY - this.getPositionY())/Math.sqrt((nextPositionX - this.getPositionX())*(nextPositionX - this.getPositionX())+(nextPositionY - this.getPositionY())*(nextPositionY - this.getPositionY())));
			}
		
			if((this.getPositionX() + this.getVelocityX() <= 1730)&&(this.getPositionX() + this.getVelocityX() > 30)&&(this.getPositionY() + this.getVelocityY()>=20)&&(this.getPositionY() + this.getVelocityY()<=150)) {
				this.setPositionX(this.getPositionX() + this.getVelocityX());
				this.setPositionY(this.getPositionY() + this.getVelocityY());
			}
			else {
				readyToStop = 100;
			}
			
			this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
			
			readyToStop ++ ;
			if(readyToStop >= 100) {
				isMoveable = false;
			}
			
		}
		else {
			this.setVelocityX(0);
			this.setVelocityY(0);
			this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
			readyToStop -- ;
			if(readyToStop == 0) {
				isMoveable = true;
			}
		}
		
	}
}
