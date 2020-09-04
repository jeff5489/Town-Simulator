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
	
	public Grocer(int indexOfPerson, Occupations grocer) {
		// TODO Auto-generated constructor stub
	}

	public boolean shouldGrocerBuyCrops() {
		boolean trueOrFalse;
		if(this.getVegetarianFoodAmount() < 300) {
//			buyCropsFromFarmer();
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return true;
	}
	
	public Person findAndReturnSeller() {
		int indexOfFarmerInFarmerList = (int)(Math.random() * ((SimulationManager.farmerList.size() - 0)));
		Person seller = SimulationManager.farmerList.get(indexOfFarmerInFarmerList);
		return seller;
	}
	
//	public boolean buyCropsFromFarmer() {
//		int amountOfCropsToBuy = 300; 
//		createTransaction(buyer, findAndReturnSeller(), buyer.getIndexOfPersonInPopulationList(), findAndReturnSeller().getIndexOfPersonInPopulationList(),
//				ProductOrServiceName.CROPS, amountOfCropsToBuy, ProductOrServicePrice.vegPrice);
//		return true;
//	}
	
//	(Person buyer, Person seller, int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
//			int idOfBuyer, ProductOrServiceName itemBought, int quantity, double price)

}