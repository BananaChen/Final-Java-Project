package person;



import items.*;

public class PokemonMaster extends Person{

	private static final long serialVersionUID = -1233480500986673884L;

	public PokemonMaster(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		
	    setImage(x, y, 200, 200, "https://i.imgur.com/L2odCO1.png");
	    
	}
	

}