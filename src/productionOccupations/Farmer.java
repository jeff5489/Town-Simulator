package productionOccupations;

import primary.Occupations;
import primary.Person;

public class Farmer extends ProductOccupationParentModel {

	public Farmer() {
		// TODO Auto-generated constructor stub
	}
	
//	public Farmer(int indexOfPerson, Occupations farmer) {
//		// TODO Auto-generated constructor stub
//	}
	
	

	@Override
	public void produce() {
		if(
//			this.getCropAmount() 
			vegetarianFoodAmount
			< 100) {
			this.addToVegetarianFoodAmount(100); 
		}
	}

	public Farmer(int id, Occupations occupation) {
		super(id, occupation);
		// TODO Auto-generated constructor stub
	}
}
