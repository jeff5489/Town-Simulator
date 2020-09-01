package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primary.Person;
import primary.SimulationManager;
class SimulationManagerTest {

	
	@Test
	void runSimulationTest() {
		SimulationManager sim = new SimulationManager();
		sim.runSimulation(100, 100);
		Person person = sim.populationList.get(0);
		assertEquals(100, sim.populationList.size(), "population should equal 100");
		
		int initialVegAmount = person.getVegetarianFoodAmount();
		sim.peopleUseResources();
		int currentVegAmount = person.getVegetarianFoodAmount();
		assertEquals(initialVegAmount, currentVegAmount + 1, "only one of vegAmount should be used");
		
		sim.checkPeoplesResources();
		int totalVegAmount = 0;
		for(Person index : sim.populationList) {
			int vegFood = index.getVegetarianFoodAmount();
			totalVegAmount += vegFood;
		}
		assertTrue(totalVegAmount > 0, "should have a positive amount of vegFood");
	}
	

}
