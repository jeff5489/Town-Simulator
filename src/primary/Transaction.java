package primary;

public class Transaction {
	public int transactionNumber;
	public int dayOfTransaction;
	public int idOfBuyer;
	public int idOfSeller;
	public ProductOrServiceName itemBought;
	public int quantity;
	public double priceOfProductOrService;
	public int indexOfBuyerInPopulationList;
	public int indexOfSellerInPopulationList;
	public double amountOfTransaction = quantity * priceOfProductOrService;
	
	Person buyer = SimulationManager.populationList.get(indexOfBuyerInPopulationList);
	Person seller = SimulationManager.populationList.get(indexOfSellerInPopulationList);
	
	public Transaction() {};
			
	public Transaction(int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, int idOfBuyer, 
			ProductOrServiceName itemBought, int quantity, double priceOfProductOrService) {
		super();
		this.idOfBuyer = idOfBuyer;
		this.itemBought = itemBought;
		this.quantity = quantity;
		this.priceOfProductOrService = priceOfProductOrService;
		this.indexOfBuyerInPopulationList = indexOfBuyerInPopulationList;
		this.indexOfSellerInPopulationList = indexOfSellerInPopulationList;
	}
	
	public void reallocateResources() {
//		System.out.println("buyer: " + buyer.toStringMinimal());
//		System.out.println("buyer: " + buyer.indexOfPersonInPopulationList);
//		decreaseBuyerMoney();
		increaseProductOrServiceOfBuyer();
//		decreaseSellerStock();
//		increaseSellerMoney();
	}
	
	public void decreaseBuyerMoney() {
		buyer.decreaseMoney(amountOfTransaction);
	}
	public void increaseProductOrServiceOfBuyer() {
		ProductOrServiceName itemBought = this.itemBought;
//		System.out.println("this.itemBought: " + this.itemBought);
//		System.out.println("quantity: " + quantity);
		switch (itemBought) {
			case VEGETARIANFOOD:
//				SimulationManager.populationList.get(indexOfBuyerInPopulationList)
				int newVegFoodAmount = buyer.vegetarianFoodAmount + this.quantity;
				SimulationManager.populationList.get(indexOfBuyerInPopulationList).setVegetarianFoodAmount(newVegFoodAmount);
				buyer.setVegetarianFoodAmount(newVegFoodAmount);
//				System.out.println("buyer.getVegetarianFoodAmount(): " + buyer.getVegetarianFoodAmount());
//				System.out.println("indexOfBuyerInPopulationList: " + indexOfBuyerInPopulationList);
				break;
			case CROPS:
				int newCropAmount = buyer.cropAmount + quantity;
				buyer.setCropAmount(newCropAmount);
				break;
			case BUILDERSERVICE:
				int newhomeQualityAmount = buyer.homeQuality + quantity;
				buyer.setHomeQuality(newhomeQualityAmount);
				break;
			case MEAT:
				int newMeatAmount = buyer.meatFoodAmount + quantity;
				buyer.setMeatFoodAmount(newMeatAmount);
				break;
			case DOCTORSERVICE:
				int newhealthAmount = buyer.health + quantity;
				buyer.setHealth(newhealthAmount);
				break;
		}
	}

	public void decreaseSellerStock() {
		ProductOrServiceName itemBought = this.itemBought;
		switch (itemBought) {
		case VEGETARIANFOOD:
			int newVegFoodAmount = seller.vegetarianFoodAmount - quantity;
			seller.setVegetarianFoodAmount(newVegFoodAmount);
			break;
		case CROPS:
			int newCropAmount = seller.cropAmount - quantity;
			seller.setCropAmount(newCropAmount);
			break;
		case BUILDERSERVICE:
			break;
		case MEAT:
			int newMeatAmount = seller.meatFoodAmount - quantity;
			seller.setMeatFoodAmount(newMeatAmount);
			break;
		case DOCTORSERVICE:
			break;
		}
	}
	public void increaseSellerMoney() {
		seller.increaseMoney(amountOfTransaction);
	}
}