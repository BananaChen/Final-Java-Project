package disturbance;

import java.util.ArrayList;
import items.*;

public class Spring extends Disturbance {

	private String imagePath = "https://i.imgur.com/JgxwTCy.png";

	public Spring(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 100, imagePath);
	}
	
	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (person.getPositionX() + person.imageWidth > this.positionX
					&& person.getPositionX() + person.imageWidth < this.positionX + this.imageWidth
					&& person.getPositionY() + person.imageHeight / 2 > this.positionY
					&& person.getPositionY() + person.imageHeight / 2 < this.positionY + this.imageHeight) {
				person.setVelocityX(getVelocityX() - 5);
			}
		}

	}

	@Override
	public void effect(ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		// TODO Auto-generated method stub
		
	}

}
