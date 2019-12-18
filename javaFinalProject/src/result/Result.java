package result;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Result {
	public JLabel label;
	
	public Result() {
		
	}

	public Result(String imagePath, int x, int y, int imageWidth, int imageHeight) {
		// create label
		try {
			ImageIcon icon = new ImageIcon(new URL(imagePath));
			label = new JLabel(icon);
			label.setSize(imageWidth, imageHeight);
			label.setLocation(x, y);
			setLabelVisibility(false);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.label);
		return panel;
	}
	
	public void setLabelVisibility(boolean is_visible) {
		this.label.setVisible(is_visible);
	}
}
