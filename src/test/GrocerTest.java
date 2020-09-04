package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primary.Occupations;
import primary.SimulationManager;
import salesOccupations.Grocer;

class GrocerTest {

	@Test
	void shouldGrocerBuyCropsTest() {
		SimulationManager sim = new SimulationManager();
		// int populationSize, int daysToRun
//		sim.runSimulation(100, 100);
		
		Grocer grocer = new Grocer();
		grocer.setId(0);
		grocer.shouldGrocerBuyCrops();
	}

}
