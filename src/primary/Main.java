// first three farmers have unusual veg amounts

// To Do

// butcher and farmers need to produce meat and crops  READ READ READ READ READ READ READ READ 
// grocers need to buy from farmers
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
	
	public static void testEditingList() {
		Person person1 = new Person();
		person1.setAge(10);
		Person person2 = new Person();
		person2.setAge(100);
		SimulationManager.populationList.add(person1);
		SimulationManager.populationList.add(person2);
		for(Person person : SimulationManager.populationList) {
			System.out.println(person.toStringMinimal());
		}
		Person personRef0 = SimulationManager.populationList.get(0);
		personRef0.setAge(99);
		System.out.println("personRef0.toString(): " + personRef0.toString());

	}
}
