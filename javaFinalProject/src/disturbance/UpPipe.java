package disturbance;

import java.util.ArrayList;

import items.*;

public class UpPipe extends Disturbance {

	private String imagePath = "https://i.imgur.com/awVA3HM.png";

	public UpPipe(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 340, imagePath);
	}

	public void effect(ArrayList<Person> persons) {
		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (person.getPositionX() + person.labelWidth > this.positionX
					&& person.getPositionY() < this.positionY + this.imageHeight
					&& person.getPositionX() < this.positionX + this.imageWidth) {
				person.setVelocityX(0);
			}
		}
	}
}
