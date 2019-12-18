package result;

public class Failure extends Result {
	
	private static String imagePath = "https://i.imgur.com/tLmAE6s.png";
	
	public Failure(int x, int y, int imageWidth, int imageHeight) {
		super(imagePath, x, y, imageWidth, imageHeight);
	}
}
