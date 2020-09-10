package primary;

public class Person {

	int id;
	int age = 18;
	Occupations occupation;
	int indexOfPersonInPopulationList;
	double money = 100;
	protected int vegetarianFoodAmount = 2;
	int meatFoodAmount = 0;
	int homeQuality = 1000;
	int health = 1000;
	public int cropAmount = 0;
	
	SimulationManager simManager = new SimulationManager();
	
	public Person() {}

	public Person(int id, Occupations occupation) {
		super();
		this.id = id;
		this.occupation = occupation;
	}
	
	public void decideToBuySomething() {
		Person buyer = SimulationManager.populationList.get(indexOfPersonInPopulationList);
		shouldPersonBuyVegFood(buyer);
		shouldPersonBuyMeat(buyer);
		shouldPersonBuyBuilderService(buyer);
		shouldPersonBuyDoctorService(buyer);
	}
	
	public Transaction createTransaction(Person buyer, Person seller, int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
			ProductOrServiceName itemBought, int quantity, double price) {
		Transaction transaction = new Transaction(indexOfBuyerInPopulationList, indexOfSellerInPopulationList, 
				itemBought, quantity, price);
		transaction.dayOfTransaction = SimulationManager.day;
		transaction.transactionNumber = SimulationManager.currentTransactionNumber;
		SimulationManager.currentTransactionNumber++;
		SimulationManager.transactionList.add(transaction);
		transaction.reallocateResources(buyer, seller);
		return transaction;
	}
	
	public boolean shouldPersonBuyVegFood(Person buyer) {
		ProductOrServiceName productOrService = ProductOrServiceName.VEGETARIANFOOD;
		int minVegAmount = 2;
		int maxVegAmount = 4;
		int randVegAmount = 1 + (int)(Math.random() * ((maxVegAmount - minVegAmount) + 1));
		if(randVegAmount <= 0) {
			System.out.println("Error Person/shouldPersonBuyVegFood randVegAmount should be positive.");
			System.out.println("randVegAmount: " + randVegAmount);
		}
		double price = ProductOrServicePrice.vegPrice;
		boolean trueOrFalse;
		if(vegetarianFoodAmount <= randVegAmount) {
			int indexOfGrocerInGrocerList = (int)(Math.random() * ((SimulationManager.grocerList.size() - 0)));
			int grocerId = SimulationManager.grocerList.get(indexOfGrocerInGrocerList).getId();
			Person seller = SimulationManager.populationList.get(grocerId);
			createTransaction(buyer, seller, indexOfPersonInPopulationList, grocerId, productOrService, 
					randVegAmount, price);
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}
	
	public boolean shouldPersonBuyMeat(Person buyer){
		boolean trueOrFalse;
		ProductOrServiceName productOrService = ProductOrServiceName.MEAT;
		int minMeatAmount = 1;
		int maxMeatAmount = 4;
		int randMeatAmount = 1 + (int)(Math.random() * ((maxMeatAmount - minMeatAmount) + 1));
		double price = ProductOrServicePrice.meatPrice;
		if(meatFoodAmount <= randMeatAmount) {
			int indexOfButcherInButcherList = (int)(Math.random() * ((SimulationManager.butcherList.size() - 0)));
			int butcherId = SimulationManager.butcherList.get(indexOfButcherInButcherList).getId();
			Person seller = SimulationManager.populationList.get(butcherId);
			createTransaction(buyer, seller, indexOfPersonInPopulationList, butcherId, productOrService, 
					randMeatAmount, price);
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}
	
	public boolean shouldPersonBuyBuilderService(Person buyer) {
		boolean trueOrFalse;
		ProductOrServiceName productOrService = ProductOrServiceName.BUILDERSERVICE;
		int minHomeQualityAmount = 1;
		int maxHomeQualityAmount = 900;
		int randHomeQualityAmount = 1 + (int)(Math.random() * ((maxHomeQualityAmount - minHomeQualityAmount) + 1));
		int randomChance = 1 + (int)(Math.random() * ((1000 - 1) + 1));
		double price = ProductOrServicePrice.builderPrice;
		if(homeQuality <= randHomeQualityAmount && randomChance == 5) {
			int indexOfBuilderInBuilderList = (int)(Math.random() * ((SimulationManager.builderList.size() - 0)));
			int builderId = SimulationManager.builderList.get(indexOfBuilderInBuilderList).getId();
			Person seller = SimulationManager.populationList.get(builderId);
			createTransaction(buyer, seller, indexOfPersonInPopulationList, builderId, productOrService, 
					100, price);
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}
	public boolean shouldPersonBuyDoctorService(Person buyer) {
		boolean trueOrFalse;
		ProductOrServiceName productOrService = ProductOrServiceName.DOCTORSERVICE;
		int minHealth = 1;
		int maxHealth = 950;
		int randHealthAmount = 1 + (int)(Math.random() * ((maxHealth - minHealth) + 1));
//		System.out.println("randHealthAmount: " + randHealthAmount);
		double price = ProductOrServicePrice.doctorPrice;
		int randomChance = 1 + (int)(Math.random() * ((1000 - 1) + 1));
//		System.out.println("randomChance: " + randomChance);
		if(health <= randHealthAmount && randomChance == 5) {
			System.out.println("health <= randHealthAmount && randomChance == 5 ... randomChance: " + randomChance);
			int indexOfDoctorInDoctorList = (int)(Math.random() * ((SimulationManager.builderList.size() - 0)));
			int doctorId = SimulationManager.builderList.get(indexOfDoctorInDoctorList).getId();
			Person seller = SimulationManager.populationList.get(doctorId);
			createTransaction(buyer, seller, indexOfPersonInPopulationList, doctorId, productOrService, 
					100, price);
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public Occupations getOccupation() {
		return occupation;
	}

	public double getMoney() {
		return money;
	}
	
	public void setMoney(double amount) {
		this.money = amount;
	}
	
	public void decreaseMoney(double amount) {
		money -= amount;
	}
	
	public void increaseMoney(double amount) {
		money += amount;
	}

	public int getVegetarianFoodAmount() {
		return vegetarianFoodAmount;
	}

	public void setVegetarianFoodAmount(int vegetarianFoodAmount) {
		this.vegetarianFoodAmount = vegetarianFoodAmount;
	}
	
	public void addToVegetarianFoodAmount(int amountToAdd) {
		this.vegetarianFoodAmount += amountToAdd;
	}

	public int getMeatFoodAmount() {
		return meatFoodAmount;
	}

	public void setMeatFoodAmount(int meatFoodAmount) {
		this.meatFoodAmount = meatFoodAmount;
	}
	public void addMeatFood(int meatFoodAmount) {
		this.meatFoodAmount += meatFoodAmount;
	}
	public void decreaseMeatFood(int meatFoodAmount) {
		this.meatFoodAmount -= meatFoodAmount;
	}

	public int getIndexOfPersonInPopulationList() {
		return indexOfPersonInPopulationList;
	}

	public void setIndexOfPersonInPopulationList(int indexOfPersonInPopulationList) {
		this.indexOfPersonInPopulationList = indexOfPersonInPopulationList;
	}

	public int getHomeQuality() {
		return homeQuality;
	}
	
	public void decreaseHomeQuality(int amountToDecrease) {
		this.homeQuality -= amountToDecrease;
	}

	public void setHomeQuality(int homeQuality) {
		this.homeQuality = homeQuality;
	}
	
	public void increaseHomeQuality(int amountToIncrease) {
		this.homeQuality += amountToIncrease;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void decreaseHealth(int amountToDecrease) {
		this.health -= amountToDecrease;
	}
	
	public void increaseHealth(int amountToincrease) {
		this.health += amountToincrease;
	}
	
	public int getCropAmount() {
		return cropAmount;
	}

	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString2() {
		return "Person [id=" + id + ", indexOfPersonInPopulationList=" + indexOfPersonInPopulationList
				+ ", vegetarianFoodAmount=" + vegetarianFoodAmount + "]";
	}
	
	public String toStringMinimal() {
		return "Person [id=" + id + ", age=" + age + "]";
	}
	
}