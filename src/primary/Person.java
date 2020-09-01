package primary;
// finish should person buy methods

public class Person {
	
//	enum occupation {
//		FARMER,
//		BUILDER,
//		BUTCHER,
//		DOCTOR,
//		GROCER
//	}

	int id;
	int age = 18;
	Occupations occupation;
//	String name = parseInt(id) + occupation.toString();
	int indexOfPersonInPopulationList;
	double money = 100;
	int vegetarianFoodAmount = 2;
	int meatFoodAmount = 0;
	int homeQuality = 100;
	int health = 2;
	int cropAmount = 0;
	
	SimulationManager simManager = new SimulationManager();
	
	public Person() {}
	
	private String parseInt(int id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person(int id, Occupations occupation) {
		super();
		this.id = id;
		this.occupation = occupation;
	}
	
	public void decideToBuySomething() {
		shouldPersonBuyVegFood();
//		shouldPersonBuyMeat();
//		shouldPersonBuyBuilderService();
//		shouldPersonBuyDoctorService();
	}
	
	public void createTransaction(int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
			int idOfBuyer, ProductOrServiceName itemBought, int quantity, double price) {
		Transaction transaction = new Transaction(indexOfBuyerInPopulationList, indexOfSellerInPopulationList, 
				idOfBuyer, itemBought, quantity, price);
		transaction.idOfSeller = (int)(Math.random() * ((SimulationManager.grocerList.size() - 0)));
		transaction.dayOfTransaction = SimulationManager.day;
		transaction.transactionNumber = SimulationManager.currentTransactionNumber;
		SimulationManager.currentTransactionNumber++;
		SimulationManager.transactionList.add(transaction);
		transaction.reallocateResources();
	}
	
	public boolean shouldPersonBuyVegFood() {
		ProductOrServiceName productOrService = ProductOrServiceName.VEGETARIANFOOD;
		int minVegAmount = 1;
		int maxVegAmount = 4;
		int randVegAmount = minVegAmount + (int)(Math.random() * ((maxVegAmount - minVegAmount) + 1));
		double price = ProductOrServicePrice.vegPrice;
//		System.out.println("this.vegetarianFoodAmount: " + this.vegetarianFoodAmount);
//		System.out.println("randVegAmount: " + randVegAmount);
		boolean trueOrFalse;
		if(this.vegetarianFoodAmount <= randVegAmount) {
			
			int indexOfGrocerInPopulationList = (int)(Math.random() * ((SimulationManager.grocerList.size() - 0)));
//			System.out.println("indexOfGrocerInPopulationList: " + indexOfGrocerInPopulationList);
//			System.out.println("indexOfPersonInPopulationList: " + indexOfPersonInPopulationList);
			createTransaction(indexOfPersonInPopulationList, indexOfGrocerInPopulationList, id, productOrService, 
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

	public int getMeatFoodAmount() {
		return meatFoodAmount;
	}

	public void setMeatFoodAmount(int meatFoodAmount) {
		this.meatFoodAmount = meatFoodAmount;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", occupation=" + occupation
				+ ", indexOfPersonInPopulationList=" + indexOfPersonInPopulationList + ", money=" + money
				+ ", vegetarianFoodAmount=" + vegetarianFoodAmount + ", meatFoodAmount=" + meatFoodAmount
				+ ", homeQuality=" + homeQuality + ", health=" + health + ", cropAmount=" + cropAmount + ", simManager="
				+ simManager + "]";
	}
	
	public String toStringMinimal() {
		return "Person [id=" + id + ", age=" + age + "]";
	}
	
}