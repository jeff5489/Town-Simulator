package primary;

public class Transaction {
	public int transactionNumber;
	public int dayOfTransaction;
//	public int idOfBuyer;
//	public int idOfSeller;
	public ProductOrServiceName itemBought;
	public int quantity;
	public double priceOfProductOrService;
	public int indexOfBuyerInPopulationList;
	public int indexOfSellerInPopulationList;
	public double amountOfTransaction = quantity * priceOfProductOrService;
	
	public Transaction() {};
			
	public Transaction(int indexOfBuyerInPopulationList, int indexOfSellerInPopulationList, 
			ProductOrServiceName itemBought, int quantity, double priceOfProductOrService) {
		super();
//		this.idOfBuyer = idOfBuyer;
		this.itemBought = itemBought;
		this.quantity = quantity;
		this.priceOfProductOrService = priceOfProductOrService;
		this.indexOfBuyerInPopulationList = indexOfBuyerInPopulationList;
		this.indexOfSellerInPopulationList = indexOfSellerInPopulationList;
		this.amountOfTransaction = quantity * priceOfProductOrService;
	}
	
	public void reallocateResources(Person buyer, Person seller) {
		
		decreaseBuyerMoney(buyer);
		increaseProductOrServiceOfBuyer(buyer, seller);
		decreaseSellerStock(seller);
		increaseSellerMoney(seller);
	}
	
	public void decreaseBuyerMoney(Person buyer) {
		buyer.decreaseMoney(amountOfTransaction);
	}
	public void increaseProductOrServiceOfBuyer(Person buyer, Person seller) {
		ProductOrServiceName itemBought = this.itemBought;
		switch (itemBought) {
			case VEGETARIANFOOD:
				int newVegFoodAmount = buyer.getVegetarianFoodAmount() + this.quantity;
				if(quantity <= 0) {
					System.out.println("Error in class Transaction, method increaseProductOrServiceOfBuyer. quantity should be positive.");
					break;
				}
				if(buyer.getVegetarianFoodAmount() <= 0) {
					System.out.println("Error in class Transaction, method increaseProductOrServiceOfBuyer. buyer.getVegetarianFoodAmount should be positive. " +
				"This may be caused by this farmer being randomly selected twice to sell veg but grocer object does check if it has enough"
				+ "to fill its order before placing order larger than amount that farmer has"
							);
					System.out.println("Current Day: " + SimulationManager.day);
					System.out.println(buyer.toString2());
					int buyerId = buyer.getId();
					for(Transaction trans : SimulationManager.transactionList) {
						if(trans.indexOfBuyerInPopulationList == buyerId || trans.indexOfSellerInPopulationList == buyerId) {
							System.out.println(trans.toString2());
//							System.out.println("Veg amount of person with negative veg: "  );
						}
					}
					break;
				}
				if(newVegFoodAmount <= 0) {
					System.out.println("Error in class Transaction, method increaseProductOrServiceOfBuyer. newVegFoodAmount should be positive.");
					break;
				}
//				SimulationManager.populationList.get(indexOfBuyerInPopulationList).setVegetarianFoodAmount(newVegFoodAmount);
//				buyer.setVegetarianFoodAmount(newVegFoodAmount);
				buyer.addToVegetarianFoodAmount(quantity);
				
				break;
			case CROPS:
				int newCropAmount = buyer.cropAmount + quantity;
//				buyer.setCropAmount(newCropAmount);
				break;
			case BUILDERSERVICE:
				int newhomeQualityAmount = buyer.homeQuality + quantity;
//				buyer.setHomeQuality(newhomeQualityAmount);
				break;
			case MEAT:
				int newMeatAmount = buyer.meatFoodAmount + quantity;
//				buyer.setMeatFoodAmount(newMeatAmount);
				break;
			case DOCTORSERVICE:
				int newhealthAmount = buyer.health + quantity;
//				buyer.setHealth(newhealthAmount);
				break;
		}
	}

	public void decreaseSellerStock(Person seller) {
		ProductOrServiceName itemBought = this.itemBought;
		switch (itemBought) {
		case VEGETARIANFOOD:
			int newVegFoodAmount = seller.vegetarianFoodAmount - quantity;
			seller.setVegetarianFoodAmount(newVegFoodAmount);
			break;
		case CROPS:
//			int newCropAmount = seller.cropAmount - quantity;
//			seller.setCropAmount(newCropAmount);
			break;
		case BUILDERSERVICE:
			break;
		case MEAT:
//			int newMeatAmount = seller.meatFoodAmount - quantity;
//			seller.setMeatFoodAmount(newMeatAmount);
			break;
		case DOCTORSERVICE:
			break;
		}
	}
	public void increaseSellerMoney(Person seller) {
		seller.increaseMoney(amountOfTransaction);
	}

	@Override
	public String toString() {
		return "Transaction [transactionNumber=" + transactionNumber 
				+ ", dayOfTransaction=" + dayOfTransaction
				+ ", itemBought=" + itemBought 
				+ ", quantity=" + quantity 
				+ ", priceOfProductOrService=" + priceOfProductOrService 
				+ ", indexOfBuyerInPopulationList=" + indexOfBuyerInPopulationList
				+ ", indexOfSellerInPopulationList=" + indexOfSellerInPopulationList 
				+ ", amountOfTransaction=" + amountOfTransaction 
				+ "]";
	}
	
	public String toString2() {
		return "Transaction [transactionNumber=" + transactionNumber 
				+ ", dayOfTransaction=" + dayOfTransaction
				+ ", itemBought=" + itemBought 
				+ ", quantity=" + quantity 
				+ ", indexOfBuyerInPopulationList=" + indexOfBuyerInPopulationList
				+ ", indexOfSellerInPopulationList=" + indexOfSellerInPopulationList 
				+ ", amountOfTransaction=" + amountOfTransaction 
				+ "]";
	}
	
}