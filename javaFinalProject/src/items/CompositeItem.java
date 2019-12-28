package items;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import windows.Scene;

public class CompositeItem extends Items{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Items> items = new ArrayList<Items>();
	
	public void move() {
		for (Items item : items) {
			item.move();
		}
	}
	
	public void effect(Scene currentScene) {
		for (Items item : items) {
//			item.effect(this.items.stream().filter(i -> i instanceof Person).collect(Collectors.toCollection(ArrayList::new)), currentScene);
			item.effect(this.items, currentScene);
		}
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (Items item : this.items) {
			item.effect(items, currentScene);
		}
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		for (Items item : this.items) {
			item.addLabelToScreen(panel);
		}
		return panel;
	}
	
	public void addItem(Items item) {
		this.items.add(item);
	}
	
	public void removeItem(Items item) {
		this.items.remove(item);
	}
	
	public void clear() {
		System.out.println("Clearing all the Items.");
		this.items.clear();
		if (this.isEmpty()) {
			System.out.println("Composite is now empty.");
		}
	}
	
	public boolean isEmpty() {
		return this.items.isEmpty();
	}
	
	public <T> ArrayList<Items> getElementsByClassInstance(Class<T> type) {
		return this.items.stream().filter(i -> type.isInstance(i))
//				.map(j -> (Items)j)
    			.collect(Collectors.toCollection(ArrayList::new));
	}
}
