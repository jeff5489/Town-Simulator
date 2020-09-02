
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
