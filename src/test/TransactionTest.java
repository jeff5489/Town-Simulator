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
	
//	(int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
//			ProductOrServiceName itemBought, int quantity, double priceOfProductOrService)
	
	@Test
	void decreaseSellerStockTest() {
		SimulationManager sim = new SimulationManager();
		sim.runSimulation(10, 10);
		Transaction trans = new Transaction(0, 1, ProductOrServiceName.VEGETARIANFOOD, 2 , 5);
//		trans.itemBought = ProductOrServiceName.VEGETARIANFOOD;
		Person tom = new Person();
		tom.setVegetarianFoodAmount(2);
		trans.decreaseSellerStock(tom);
		assertEquals(0, tom.getVegetarianFoodAmount(), "money should be equal to 0");
	}
	
	@Test
	void increaseSellerMoneyTest() {
		SimulationManager sim = new SimulationManager();
		sim.runSimulation(10, 10);
		Transaction trans = new Transaction(0, 1, ProductOrServiceName.VEGETARIANFOOD, 2 , 5);
		Person dick = new Person();
		dick.setMoney(10);
		trans.increaseSellerMoney(dick);
		assertEquals(dick.getMoney(), 20, "money should be equal to 20");
	}

	@Test
	void decreaseBuyerMoneyTest() {
		Transaction trans = new Transaction(0, 1, ProductOrServiceName.VEGETARIANFOOD, 2 , 5);
		Person tom = new Person();
		tom.setMoney(10);
		trans.decreaseBuyerMoney(tom);
		assertEquals(tom.getMoney(), 0, "money should be equal to 0");
	}
	
	@Test
	void increaseProductOrServiceOfBuyerTest() {
		SimulationManager sim = new SimulationManager();
		sim.createPeople(10);
		
		Person buyer = SimulationManager.populationList.get(0);
		Person tom = new Person();
		Person seller = new Person();
		
		tom.setVegetarianFoodAmount(1);
//		System.out.println("tom.getVegetarianFoodAmount(): " + tom.getVegetarianFoodAmount());
		
		Transaction trans = new Transaction();
		trans.indexOfBuyerInPopulationList = 0;
		trans.itemBought = ProductOrServiceName.VEGETARIANFOOD;
		trans.quantity = 5;
		trans.increaseProductOrServiceOfBuyer(tom, seller);
		
//		System.out.println("tom.getVegetarianFoodAmount(): " + tom.getVegetarianFoodAmount());
		
		assertTrue(tom.getVegetarianFoodAmount() == 6, "amount should be 6");
//		indexOfBuyerInPopulationList
	}
	

}
