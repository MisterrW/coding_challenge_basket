package shoppingbasket;

public class Shopper {
	private boolean loyaltyCard;
	private String name;

	public Shopper(String name, boolean loyaltyCard){
		this.name = name;
		this.loyaltyCard = loyaltyCard;
	}

	public boolean hasLoyaltyCard() {
		return this.loyaltyCard;
	}
}