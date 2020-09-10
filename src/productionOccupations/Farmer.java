package productionOccupations;

import primary.Occupations;
import primary.Person;

public class Farmer extends ProductOccupationParentModel {

	public Farmer() {}

	@Override
	public void produce() {
		if(vegetarianFoodAmount< 200) {
			this.addToVegetarianFoodAmount(100); 
		}
	}

	public Farmer(int id, Occupations occupation) {
		super(id, occupation);
	}
}
