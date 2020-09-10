package productionOccupations;

import primary.Occupations;

public class Butcher extends ProductOccupationParentModel {

	public Butcher() {}
	
	public Butcher(int id, Occupations occupation) {
		super(id, occupation);
	}

	@Override
	public void produce() {
		if(this.getMeatFoodAmount() < 70) {
			this.addMeatFood(50); 
		}	
	}

}