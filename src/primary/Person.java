package primary;

public class Person {

	int id;
	int age = 18;
	Occupations occupation;
	int indexOfPersonInPopulationList;
	double money = 100;
	protected int vegetarianFoodAmount = 2;
	int meatFoodAmount = 0;
	int homeQuality = 100;
	int health = 2;
	int cropAmount = 0;
	
	SimulationManager simManager = new SimulationManager();
//	protected Person buyer = SimulationManager.populationList.get(indexOfPersonInPopulationList);
//	protected Person buyer;
	
	public Person() {
//		buyer = SimulationManager.populationList.get(indexOfPersonInPopulationList);
	}

	public Person(int id, Occupations occupation) {
		super();
		this.id = id;
		this.occupation = occupation;
//		this.buyer = SimulationManager.populationList.get(indexOfPersonInPopulationList);
	}
	
	public void decideToBuySomething() {
		Person buyer = SimulationManager.populationList.get(indexOfPersonInPopulationList);

		
		shouldPersonBuyVegFood(buyer);
//		shouldPersonBuyMeat(buyer);
//		shouldPersonBuyBuilderService(buyer);
//		shouldPersonBuyDoctorService(buyer);
	}
	
	public Transaction createTransaction(Person buyer, Person seller, int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
			ProductOrServiceName itemBought, int quantity, double price) {
		Transaction transaction = new Transaction(indexOfBuyerInPopulationList, indexOfSellerInPopulationList, 
				itemBought, quantity, price);
//		transaction.idOfSeller = (int)(Math.random() * ((SimulationManager.grocerList.size() - 0)));
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
			int indexOfGrocerInPopulationList = (int)(Math.random() * ((SimulationManager.grocerList.size() - 0)));
			Person seller = SimulationManager.populationList.get(indexOfGrocerInPopulationList);
			createTransaction(buyer, seller, indexOfPersonInPopulationList, indexOfGrocerInPopulationList, productOrService, 
					randVegAmount, price);
			trueOrFalse = true;
		}else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}
	public void shouldPersonBuyMeat(){
			
	}
	public void shouldPersonBuyBuilderService() {
		
	}
	public void shouldPersonBuyDoctorService() {
		
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
	
//	public String getName() {
//		return name;
//	}

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
	public void deductMeatFood(int meatFoodAmount) {
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

	public void setHomeQuality(int homeQuality) {
		this.homeQuality = homeQuality;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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