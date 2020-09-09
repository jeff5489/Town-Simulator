package salesOccupations;

import primary.Occupations;
import primary.Person;
import primary.ProductOrServiceName;
import primary.ProductOrServicePrice;
import primary.SimulationManager;
import productionOccupations.ProductOccupationParentModel;

public class Grocer extends Person {

	public Grocer() {
		// TODO Auto-generated constructor stub
	}
	
	public Grocer(int id, Occupations occupation) {
		super(id, occupation);
		// TODO Auto-generated constructor stub
	}

	public boolean shouldGrocerBuyCrops() {
		
		boolean trueOrFalse;
		if(this.getVegetarianFoodAmount() < 300) {
			buyVegFromFarmer();
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return true;
	}
	
//	public Person getFarmerWithPositiveVegAmount() {
//		Person seller = getRandomFarmer();
//		if(seller.getVegetarianFoodAmount() > 400) {
//			return seller;
//		} else {
//			System.out.println("seller.getVegetarianFoodAmount() > 400 ... seller.getVegetarianFoodAmount(): " + seller.getVegetarianFoodAmount());
//			System.out.println("Seller id: " + seller.getId());
////			getFarmerWithPositiveVegAmount();
////			buyVegFromFarmer();
//		}
//		return seller;
//	}
	
	public Person getFarmerWithPositiveVegAmount() {
		Person seller;
		do {
			seller = getRandomFarmer();
		}
		while(seller.getVegetarianFoodAmount() < 400);
		return seller;
	}
	
	public Person getRandomFarmer() {
		int indexOfFarmerInFarmerList = (int)(Math.random() * ((SimulationManager.farmerList.size() - 0)));
		Person seller = SimulationManager.farmerList.get(indexOfFarmerInFarmerList);
		return seller;
	}
	
	public boolean buyVegFromFarmer() {
		Person seller = getFarmerWithPositiveVegAmount();
		int amountOfVegToBuy = 300; 
		Person buyer = SimulationManager.populationList.get(this.getIndexOfPersonInPopulationList());
//		System.out.println("in buyCropsFromFarmer() - buyer.getOccupation(): " + buyer.getOccupation());
		createTransaction(buyer, seller, buyer.getIndexOfPersonInPopulationList(), seller.getIndexOfPersonInPopulationList(),
				ProductOrServiceName.VEGETARIANFOOD, amountOfVegToBuy, ProductOrServicePrice.vegPrice);
		return true;
	}

}