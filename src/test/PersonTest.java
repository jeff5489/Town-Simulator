package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import primary.Occupations;
import primary.Person;
import primary.SimulationManager;

class PersonTest {

	@Test
	void shouldPersonBuyVegFoodTest() {
		SimulationManager sim = new SimulationManager();
		sim.runSimulation(10, 10);
		Person tom = new Person(0, Occupations.FARMER);
		tom.setVegetarianFoodAmount(0);
		assertTrue(tom.shouldPersonBuyVegFood(tom), "vegetarianFoodAmount <= randVegAmount is false");
	}

}
