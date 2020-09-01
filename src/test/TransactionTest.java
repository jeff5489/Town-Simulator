package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primary.Occupations;
import primary.Person;
import primary.ProductOrServiceName;
import primary.SimulationManager;
import primary.Transaction;
import primary.ProductOrServiceName;

class TransactionTest {
	
//	int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, int idOfBuyer, 
//	ProductOrServiceName itemBought, int quantity, double priceOfProductOrService
	
	

	@Test
	void decreaseBuyerMoneyTest() {
		Person tom = new Person();
		tom.setMoney(11);
		tom.decreaseMoney(10);
		assertEquals(tom.getMoney(), 1, "money should be equal to 1");
	}
	
	@Test
	void increaseProductOrServiceOfBuyerTest() {
		SimulationManager sim = new SimulationManager();
		sim.createPeople(10);
		
		Person buyer = SimulationManager.populationList.get(0);
		Person tom = new Person();
		
		tom.setVegetarianFoodAmount(1);
		System.out.println("tom.getVegetarianFoodAmount(): " + tom.getVegetarianFoodAmount());
		
		Transaction trans = new Transaction();
		trans.indexOfBuyerInPopulationList = 0;
		trans.itemBought = ProductOrServiceName.VEGETARIANFOOD;
		trans.quantity = 5;
		trans.increaseProductOrServiceOfBuyer();
		
		System.out.println("tom.getVegetarianFoodAmount(): " + tom.getVegetarianFoodAmount());
		
		assertTrue(tom.getVegetarianFoodAmount() == 6, "amount should be 6");
//		indexOfBuyerInPopulationList
	}

}
