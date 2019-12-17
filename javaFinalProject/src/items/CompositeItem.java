package items;

import java.util.ArrayList;

public abstract class CompositeItem extends Items{

	public ArrayList<Items> items;
	
	@Override
	public void move() {
		for (Items item : items) {
			item.move();
		}
	}
}
