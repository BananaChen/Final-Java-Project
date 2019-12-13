package command;

import java.util.HashMap;

import windows.Scene;

public class RemoteController {
	
	private HashMap<Integer, Command> controller = new HashMap<Integer, Command>();
	
	public RemoteController() {
		
	}
	
	public void setRemoteController(int key, Command control) {
		controller.put(key, control);
    }
	
	public void pressButton(int key, Scene scene) {
		if (controller.containsKey(key)) {
			controller.get(key).execute(scene);
		}
	}
}
