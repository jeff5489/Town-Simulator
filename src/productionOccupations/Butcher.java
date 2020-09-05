package productionOccupations;

import primary.Occupations;

public class Butcher extends ProductOccupationParentModel {

	public Butcher() {
		// TODO Auto-generated constructor stub
	}
	
	public Butcher(int id, Occupations occupation) {
		super(id, occupation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void produce() {
		if(this.getMeatFoodAmount() < 70) {
			this.addMeatFood(50); 
		}
		
	}

}
