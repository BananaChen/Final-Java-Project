package items;

import java.util.ArrayList;
import java.util.stream.Collectors;

import windows.Scene;

import java.lang.reflect.InvocationTargetException;
//import java.sql.*;

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
			item.effect(this.items.stream().filter(i -> i instanceof Person).collect(Collectors.toCollection(ArrayList::new)), currentScene);
		}
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (Items item : this.items) {
			item.effect(items, currentScene);
		}
	}
	
	// add element to list
	public void addItem(Items item) {
		this.items.add(item);
	}
	
	// remove element from list
	public void removeItem(Items item) {
		this.items.remove(item);
	}
	
	// clean all elements
	public void clear() {
		System.out.println("Clearing all the Items.");
		this.items.clear();
		if (this.isEmpty()) {
			System.out.println("Composite is now empty.");
		}
	}
	
	// check if list is empty
	public boolean isEmpty() {
		return this.items.isEmpty();
	}
	
	public <T> ArrayList<Items> getElementsByClassInstance(Class<T> type) {
		return this.items.stream().filter(i -> type.isInstance(i))
//				.map(j -> (Items)j)
    			.collect(Collectors.toCollection(ArrayList::new));
	}
	
}
