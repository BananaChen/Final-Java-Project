package aircraft;


import java.util.Random;

import items.Aircraft;


public class UFO extends Aircraft {

	private Random random = new Random();
	private int nextPositionX = 0;
	private int nextPositionY = 0;
	private boolean isMoveable = true;
	private int readyToStop = 0;
	
	//private String imagePath = "https://i.imgur.com/4G0ZiGK.gif";
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
				this.velocityX = 10*(nextPositionX - this.positionX)/Math.sqrt((nextPositionX - this.positionX)*(nextPositionX - this.positionX)+(nextPositionY - this.positionY)*(nextPositionY - this.positionY));
				this.velocityY = 10*(nextPositionY - this.positionY)/Math.sqrt((nextPositionX - this.positionX)*(nextPositionX - this.positionX)+(nextPositionY - this.positionY)*(nextPositionY - this.positionY));
			}
		
			if((this.positionX + this.velocityX <= 1730)&&(this.positionX + this.velocityX > 30)&&(this.positionY + this.velocityY>=20)&&(this.positionY + this.velocityY<=150)) {
				this.positionX += this.velocityX;
				this.positionY += this.velocityY;
			}
			else {
				readyToStop = 100;
			}
			
			this.lb.setLocation((int) this.positionX, (int) this.positionY);
			
			readyToStop ++ ;
			if(readyToStop >= 100) {
				isMoveable = false;
			}
			
		}
		else {
			this.velocityX = 0;
			this.velocityY = 0;
			this.lb.setLocation((int) this.positionX, (int) this.positionY);
			readyToStop -- ;
			if(readyToStop == 0) {
				isMoveable = true;
			}
		}
		
	}
}
