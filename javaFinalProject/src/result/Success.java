package result;

public class Success extends Result {
	
	private static String imagePath = "https://i.imgur.com/kGYlNur.png";
	
	public Success(int x, int y, int imageWidth, int imageHeight) {
		super(imagePath, x, y, imageWidth, imageHeight);
	}
}
