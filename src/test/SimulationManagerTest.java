package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primary.Occupations;
import primary.Person;
import primary.SimulationManager;
import productionOccupations.Butcher;
class SimulationManagerTest {


	SimulationManager sim = new SimulationManager();
//	sim.runSimulation(100, 100);
	
	@Test
	void runSimulationTest() {
//		SimulationManager sim = new SimulationManager();
		sim.runSimulation(100, 100);
		Person person = sim.populationList.get(0);
		assertEquals(100, sim.populationList.size(), "population should equal 100");
		
		int initialVegAmount = person.getVegetarianFoodAmount();
		sim.peopleUseResources();
		int currentVegAmount = person.getVegetarianFoodAmount();
		assertEquals(initialVegAmount, currentVegAmount + 1, "only one of vegAmount should be used");
		
//		sim.checkPeoplesResources();
		int totalVegAmount = 0;
		for(Person index : sim.populationList) {
			int vegFood = index.getVegetarianFoodAmount();
			totalVegAmount += vegFood;
		}
		assertTrue(totalVegAmount > 0, "should have a positive amount of vegFood");
	}
	
	@Test
	void sim2() {
		assertTrue(SimulationManager.butcherList.size() == 4, "butcherList is supposed to have a size of 4");
	}
	
	@Test
	void checkPeoplesResources() {
		int i = 0;
		for(Person person: sim.populationList) {
//			System.out.println(i + " : " + person.getOccupation());
			assertNotNull(person.getOccupation(), "Occupation should be set");
			assertEquals(person.getIndexOfPersonInPopulationList(), i, "index should be equal to i");
//			assertTrue(person.getMoney()>0, "money should be positive amount");
			assertTrue(person.getVegetarianFoodAmount() >0, "veg should be positive amount");
//			assertTrue(person.getMeatFoodAmount() >0, "meat should be positive amount");
			assertTrue(person.getHomeQuality() >0, "HomeQuality should be positive amount");
			assertTrue(person.getHealth() >0, "health should be positive amount");
			assertTrue(person.getCropAmount() > -1, "crop should be 0: " + person.getIndexOfPersonInPopulationList());
			i++;
		}
//		int id;
//		int age = 18;
//		Occupations occupation;
//		int indexOfPersonInPopulationList;
//		double money = 100;
//		protected int vegetarianFoodAmount = 2;
//		int meatFoodAmount = 0;
//		int homeQuality = 100;
//		int health = 2;
//		int cropAmount = 0;
	}

}
