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

	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Items> getPerson() {
		return this.items.stream().filter(i -> i instanceof Person)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Items> getAircraft() {
		return this.items.stream().filter(i -> i instanceof Aircraft)
    			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Items> getDisturbance() {
		return this.items.stream().filter(i -> i instanceof Disturbance)
    			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Items> getDestination() {
		return this.items.stream().filter(i -> i instanceof Destination)
    			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public <T> ArrayList<Items> getElementsByClass(Class<T> cls) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
        T inst = cls.getConstructor().newInstance();
        ArrayList<Items> list = new ArrayList<Items>();
        
        if (inst instanceof Person) {
        	return this.items.stream().filter(i -> i instanceof Person)
        			.map(j -> (Items)j)
        			.collect(Collectors.toCollection(ArrayList::new));
        } else if (inst instanceof Disturbance) {
        	return this.items.stream().filter(i -> i instanceof Disturbance)
        			.map(j -> (Items)j)
        			.collect(Collectors.toCollection(ArrayList::new));
        } else if (inst instanceof Destination) {
        	return this.items.stream().filter(i -> i instanceof Destination)
        			.map(j -> (Items)j)
        			.collect(Collectors.toCollection(ArrayList::new));
        } else if (inst instanceof Aircraft) {
        	return this.items.stream().filter(i -> i instanceof Aircraft)
        			.map(j -> (Items)j)
        			.collect(Collectors.toCollection(ArrayList::new));
//        	for (Items item : this.items) {
//	    		if (item instanceof Disturbance) {
//	    			list.add((T) item);
//	    		}
//	    	}
        } else {
        	return list;
        }
//		ArrayList<T> list = (ArrayList<T>) this.items.query("SELECT * FROM objects WHERE type=" + cls.getName());
    }
	
//	public <Any> Any getElementsByClass(Class cls) {
//		Class c = cls.getClass(); 
//		ArrayList<Items> selectedItems = new ArrayList<Items>();
//		for (Items item : items) {
//			System.out.println(item.getClass().getName());
//			if (item.getClass().getName() == className) {
//				selectedItems.add(item);
//			}
//		}
//		
//		return (Any) selectedItems;
//	}
	
//	public ArrayList<Items> getElementsByClass(String className) {
//		 ArrayList<Items> selectedItems = new ArrayList<Items>();
//		for (Items item : items) {
//			System.out.println(item.getClass().getName());
//			if (item.getClass().getName() == className) {
//				selectedItems.add(item);
//			}
//		}
//		
//		return selectedItems;
//	}
}
