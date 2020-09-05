package primary;
import java.util.ArrayList;
import java.util.List;

import productionOccupations.Butcher;
import productionOccupations.Farmer;

public class SimulationManager {
	
	public static int populationSize;
	public static int day;
	public static int currentTransactionNumber;
	
	public static List<Person> populationList = new ArrayList<Person>();
	public static List<Transaction> transactionList = new ArrayList<Transaction>();
	public static List<Person> grocerList = new ArrayList<Person>();
	public static List<Butcher> butcherList = new ArrayList<Butcher>();
	public static List<Farmer> farmerList = new ArrayList<Farmer>();
	
	public SimulationManager() {
	}

	public void runSimulation(int populationSize, int daysToRun){
		System.out.println("Simulation started");

		// store in populationList
		createPeople(populationSize);
		day++;
		while(day <= daysToRun) {
//			System.out.println("Day: " + day);
			productOccupationsProduceProducts();
			peopleUseResources();
			checkPeoplesResources();
//			checkResourceFluctuation();
//			returnInfo();
//			reviewOnePerson();
		}
//		printVegAmountOfAllPeople();
//		printMoneyOfAllPeople();
//		printCropOfAllPeople();
	}
	
	public void productOccupationsProduceProducts() {
		for(Butcher butcher : butcherList) {
			butcher.produce();
		}
		for(Farmer farmer : farmerList) {
			farmer.produce();
		}
	}
	public void printMoneyOfAllPeople() {
		System.out.println("printMoneyOfAllPeople() reached");
		for(Person person : populationList) {
			System.out.println(person.getMoney());
		}
	}
	public void printCropOfAllPeople() {
		System.out.println("printCropOfAllPeople() reached");
		for(Person person : populationList) {
			System.out.println(person.getCropAmount());
		}
	}
	
	public void printVegAmountOfAllPeople() {
		System.out.println("printAllVegAmountOfAllPeople() reached");
		for(Person person : populationList) {
			System.out.println("Veg Amount: " + person.getVegetarianFoodAmount());
			System.out.println("Occupation: " + person.getOccupation());
		}
	}
	
	public void checkResourceFluctuation() {
		int totalVegAllPeople = 0;
		for(Person person : populationList) {
			totalVegAllPeople += person.getVegetarianFoodAmount();
		}
		System.out.println("totalVegAllPeople: " + totalVegAllPeople);
	}
	
	public void reviewOnePerson() {
		Person person = populationList.get(0);
//		System.out.println("Day: " + day);
		System.out.println("Person 0 veg food: " + person.vegetarianFoodAmount);
	}
	
	public void returnInfo() {
//		System.out.println("returnInfo method reached");
		int totalVegFoodInTransactions = 0; 
		for(Transaction trans : transactionList) {
			totalVegFoodInTransactions += trans.quantity;
		}
		System.out.println("quantity of vegfood in transactions: " + totalVegFoodInTransactions);
	}
	
	public void checkPeoplesResources() {
//		System.out.println("checkPeoplesResources method reached");
		// for each person in popList create transaction to increase changing field in low
		
		for(Person person : populationList) {
			person.decideToBuySomething();
		}
		day++;
	}
	
	public void peopleUseResources() {
//		System.out.println("peopleUseResources method reached");
		for(Person person : populationList) {
			person.setVegetarianFoodAmount(person.vegetarianFoodAmount - 1);
		}
	}
	
	public void createPeople(int populationSize) {
//		System.out.println("createPeople method reached");
		
		int indexOfPerson = 0;
		
		// assign percentages 
		
		double farmerPercent = .87;
		double grocerPercent =.03;
		double builderPercent = .05;
		double butcherPercent = .04;
		double doctorPercent =.01;
		
		// turn percentages into actual integers
		
		double farmerDouble = populationSize * farmerPercent;
		int farmerInt = (int) Math.round(farmerDouble);
		double builderDouble = populationSize * builderPercent;
		int builderInt = (int) Math.round(builderDouble);
		double butcherDouble = populationSize * butcherPercent;
		int butcherInt = (int) Math.round(butcherDouble);
		double doctorDouble = populationSize * doctorPercent;
		int doctorInt = (int) Math.round(doctorDouble);
		double grocerDouble = populationSize * grocerPercent;
		int grocerInt = (int) Math.round(grocerDouble);
		
//		System.out.println("Number of Farmers: " + farmerInt);
//		System.out.println("Number of Builders: " + builderInt);
//		System.out.println("Number of Butchers: " + butcherInt);
//		System.out.println("Number of Doctors: " + doctorInt);
//		System.out.println("Number of Grocers: " + grocerInt);
						
		// construct persons and assign ids and occupations
		
		for(int i = 0; i < farmerInt; i++) {
			Farmer farmer = new Farmer(indexOfPerson, Occupations.FARMER);
			farmer.setIndexOfPersonInPopulationList(indexOfPerson);
			indexOfPerson++;
			farmerList.add(farmer);
			populationList.add(farmer);
		}
		for(int i = 0; i < builderInt; i++) {
			Person person = new Person(indexOfPerson, Occupations.BUILDER);
			person.indexOfPersonInPopulationList = indexOfPerson;
			indexOfPerson++;
			populationList.add(person);
		}
		for(int i = 0; i < butcherInt; i++) {
			Butcher butcher = new Butcher(indexOfPerson, Occupations.BUTCHER);
			butcher.setIndexOfPersonInPopulationList(indexOfPerson);
			indexOfPerson++;
			butcherList.add(butcher);
//			System.out.println("butcher.getIndex: " + butcher.getIndexOfPersonInPopulationList());
			populationList.add(butcher);
		}
		for(int i = 0; i < doctorInt; i++) {
			Person person = new Person(indexOfPerson, Occupations.DOCTOR);
//			Person person = new Person();
			person.indexOfPersonInPopulationList = indexOfPerson;
			indexOfPerson++;
			populationList.add(person);
		}
		for(int i = 0; i < grocerInt; i++) {
			Person person = new Person(indexOfPerson, Occupations.GROCER);
			person.indexOfPersonInPopulationList = indexOfPerson;
			indexOfPerson++;
			grocerList.add(person);
			populationList.add(person);
		}
	}
	
	public void addToTransactionList(Transaction transaction) {
		transactionList.add(transaction);
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public List<Person> getPopulationList() {
		return populationList;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	

	
	public int getCurrentTransactionNumber() {
		return currentTransactionNumber;
	}

	public void setCurrentTransactionNumber(int currentTransactionNumber) {
		this.currentTransactionNumber = currentTransactionNumber;
	}

//	public void addToTransactionList2(Transaction trans) {
//		transactionList.add(trans);
//		
//	}
	
	
	
}
