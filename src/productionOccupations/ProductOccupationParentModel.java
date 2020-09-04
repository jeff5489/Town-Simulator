package productionOccupations;

import primary.Occupations;
import primary.Person;

public abstract class ProductOccupationParentModel extends Person {

//	public ProductOccupationParentModel() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	public abstract void produce();

	public ProductOccupationParentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOccupationParentModel(int id, Occupations occupation) {
		super(id, occupation);
		// TODO Auto-generated constructor stub
	}

}
