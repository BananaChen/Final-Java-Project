package windows;

import java.util.ArrayList;

import aircraft.Bee;
import aircraft.RollerCoaster;
import destination.Home;
import destination.Honeycomb;
import disturbance.Arrow;
import disturbance.FireBall;
import items.Aircraft;
import items.Destination;
import items.Disturbance;
import items.Items;
import items.Person;
import person.PokemonMaster;

public class Stage5Factory implements SceneFactory{
	
	@Override
	public ArrayList<Items> createPerson() {
		ArrayList<Items> persons = new ArrayList<Items>();
		Person person = new PokemonMaster(50, 50, 0, 0, 0, 0.01);
		person.lb.setVisible(false);
		persons.add(person);
		
		return persons;
		
	}

	@Override
	public ArrayList<Items> createAircraft() {
		ArrayList<Items> aircrafts = new ArrayList<Items>();
		
		Aircraft roller1 = new RollerCoaster(900, 30, 0, 0, 247.5, 0);
		roller1.setImage(1, 1, 150, 150, "https://i.imgur.com/ggI5oOx.png");
		
		Aircraft roller2 = new RollerCoaster(950, 100, 0, 0, 270, 0);
		roller2.setImage(1, 1, 100, 100, "https://i.imgur.com/zkSxHWX.png");
		
		Aircraft roller3 = new RollerCoaster(1020, 100, 0, 0, 292.5, 0);
		roller3.setImage(1, 1, 100, 100, "https://i.imgur.com/kMty2NS.png");
		
		Aircraft roller4 = new RollerCoaster(1090, 80, 0, 0, 315, 0);
		roller4.setImage(1, 1, 50, 70, "https://i.imgur.com/WNpfnuS.png");
		
		Aircraft roller5 = new RollerCoaster(1130, 50, 0, 0, 337.5, 0);
		roller5.setImage(1, 1, 100, 100, "https://i.imgur.com/5FXCIEX.png");
		
		Aircraft roller6 = new RollerCoaster(1180, 50, 0, 0, 360, 0);
		roller6.setImage(1, 1, 100, 100, "https://i.imgur.com/GFtcyKx.png");
		
		aircrafts.add(roller1);
		aircrafts.add(roller2);
		aircrafts.add(roller3);
		aircrafts.add(roller4);
		aircrafts.add(roller5);
		aircrafts.add(roller6);
		
		return aircrafts;
	}

	@Override
	public ArrayList<Items> createDestination() {
		ArrayList<Items> destinations = new ArrayList<Items>();
		Destination destination = new Home(600, 650, 1, 1, 1, 1);
		destinations.add(destination);
		
		return destinations;
	}

	@Override
	public ArrayList<Items> createDisturbance() {
		ArrayList<Items> disturbances = new ArrayList<Items>();
		for (int i = 0; i < 4; ++i) {
			disturbances.add(new FireBall(0, 700, 0, 0, 0, 0, "https://i.imgur.com/I9l1stq.png"));
		}
		
		return disturbances;
	}
}
