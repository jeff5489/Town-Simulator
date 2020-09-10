
// To Do

// people need to buy from butcher - done
// homes need to deteriorate
// builder needs to improve home quality
// people's health need to have illness events
// doctor needs to provide health services
// 


// test createTransaction in Person class
// all people need to buy meat
// home quality needs to decrease over time
// home quality needs to be purchased from builders
// health needs to decrease over time
// health needs to be purchased from doctors
// deduct taxes from each person

// person can't buy something if seller hasn't produced it yet

// determine how much value each occupation can produce
// people can't work or produce value without the resources needed for their jobs
// create logic for supply and demand? 

package primary;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		SimulationManager sim = new SimulationManager();
		// int populationSize, int daysToRun
		sim.runSimulation(100, 100);
	}
}
