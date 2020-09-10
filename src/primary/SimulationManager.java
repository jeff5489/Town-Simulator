package primary;
import java.util.ArrayList;
import java.util.List;

import productionOccupations.Butcher;
import productionOccupations.Farmer;
import salesOccupations.Grocer;
import serviceOccupations.Builder;
import serviceOccupations.Doctor;

public class SimulationManager {
	
	public static int populationSize;
	public static int day;
	public static int currentTransactionNumber;
	
	public static List<Person> populationList = new ArrayList<Person>();
	public static List<Transaction> transactionList = new ArrayList<Transaction>();
	public static List<Grocer> grocerList = new ArrayList<Grocer>();
	public static List<Butcher> butcherList = new ArrayList<Butcher>();
	public static List<Farmer> farmerList = new ArrayList<Farmer>();
	public static List<Builder> builderList = new ArrayList<Builder>();
	public static List<Doctor> doctorList = new ArrayList<Doctor>();
	
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
			salesOccupationsDailyMethodsToRun();
			peopleUseResources();
			checkPeoplesResources();
//			checkResourceFluctuation();
//			returnInfo();
//			reviewOnePerson();
//			printTransactions();
		}
//		printHomeQualityOfAllPeople();
//		printHealthOfAllPeople();
//		printMeatAmountOfAllPeople();
//		printVegAmountOfAllPeople();
//		printVegAmountOfGrocers();
//		printMoneyOfAllPeople();
//		printCropOfAllPeople();
//		printWhatINeedRightNow();
	}
	
	public void printHomeQualityOfAllPeople() {
		for(Person person : populationList) {
			System.out.println("id: " + person.getId() + " home quality: " + person.getHomeQuality());
		}
	}
	
	public void printHealthOfAllPeople() {
		System.out.println("printHealthOfAllPeople() reached");
		for(Person person : populationList) {
			System.out.println("id: " + person.getId() + " health: " + person.getHealth());
		}
	}
	
	public void printMeatAmountOfAllPeople() {
		for(Person person : populationList) {
			System.out.println("id: " + person.getId() + " meat amount: " + person.getMeatFoodAmount());
		}
	}
	
	public void printWhatINeedRightNow() {
		System.out.println("printWhatINeedRightNow() reached");
//		for(Grocer grocer : grocerList) {
//			System.out.println("grocer.getCropAmount(): " + grocer.getCropAmount());
////			System.out.println("grocer.cropAmount: " + grocer.cropAmount);
//		}
	}
	
	public void printTransactions() {
		for(Transaction trans : transactionList) {
			if(trans.itemBought == ProductOrServiceName.CROPS) {
				System.out.println("Transaction: " + trans.toString());
			}
		}
	}
	
	public void salesOccupationsDailyMethodsToRun() {
		for(Grocer grocer : grocerList) {
//			System.out.println("Grocer id: " + grocer.getId());
			grocer.shouldGrocerBuyCrops();
		}
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
			System.out.println("person.getId(): " + person.getId() + " Occupation: " + person.getOccupation());
		}
	}
	
	public void printVegAmountOfGrocers() {
		System.out.println("printAllVegAmountOfGrocers() reached");
		for(Person person : grocerList) {
			System.out.println("Veg Amount: " + person.getVegetarianFoodAmount());
			System.out.println("person.getId(): " + person.getId() + " Occupation: " + person.getOccupation());
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
		System.out.println("Person 0 veg food: " + person.vegetarianFoodAmount);
	}
	
	public void returnInfo() {
		int totalVegFoodInTransactions = 0; 
		for(Transaction trans : transactionList) {
			totalVegFoodInTransactions += trans.quantity;
		}
		System.out.println("quantity of vegfood in transactions: " + totalVegFoodInTransactions);
	}
	
	public void checkPeoplesResources() {		
		for(Person person : populationList) {
			person.decideToBuySomething();
		}
		day++;
	}
	
	public void peopleUseResources() {
		for(Person person : populationList) {
			person.setVegetarianFoodAmount(person.vegetarianFoodAmount - 1);
			person.decreaseMeatFood(1);
			person.decreaseHomeQuality(1);
			person.decreaseHealth(1);
		}
	}
	
	public void createPeople(int populationSize) {
		
		int indexOfPerson = 0;
		
		double farmerPercent = .87;
		double grocerPercent =.03;
		double builderPercent = .05;
		double butcherPercent = .04;
		double doctorPercent =.01;
		
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
		
		for(int i = 0; i < farmerInt; i++) {
			Farmer farmer = new Farmer(indexOfPerson, Occupations.FARMER);
			farmer.setIndexOfPersonInPopulationList(indexOfPerson);
			farmer.setVegetarianFoodAmount(500);
			indexOfPerson++;
			farmerList.add(farmer);
			populationList.add(farmer);
		}
		for(int i = 0; i < builderInt; i++) {
			Builder builder = new Builder(indexOfPerson, Occupations.BUILDER);
			builder.setIndexOfPersonInPopulationList(indexOfPerson);
			indexOfPerson++;
			builderList.add(builder);
			populationList.add(builder);
		}
		for(int i = 0; i < butcherInt; i++) {
			Butcher butcher = new Butcher(indexOfPerson, Occupations.BUTCHER);
			butcher.setIndexOfPersonInPopulationList(indexOfPerson);
			butcher.setMeatFoodAmount(100);
			indexOfPerson++;
			butcherList.add(butcher);
			populationList.add(butcher);
		}
		for(int i = 0; i < doctorInt; i++) {
			Doctor doctor = new Doctor(indexOfPerson, Occupations.DOCTOR);
			doctor.setIndexOfPersonInPopulationList(indexOfPerson);
			indexOfPerson++;
			doctorList.add(doctor);
			populationList.add(doctor);
		}
		for(int i = 0; i < grocerInt; i++) {
			Grocer grocer = new Grocer(indexOfPerson, Occupations.GROCER);
			grocer.setIndexOfPersonInPopulationList(indexOfPerson);
			indexOfPerson++;
			grocerList.add(grocer);
			populationList.add(grocer);
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
	
}