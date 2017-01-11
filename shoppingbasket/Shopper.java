package shoppingbasket;

public class Shopper {
	private boolean loyaltyCard;
	private String name;
	private Basket basket;

	public Shopper(String name, boolean loyaltyCard, Basket basket){
		this.name = name;
		this.loyaltyCard = loyaltyCard;
		this.basket = basket;
	}

	public boolean hasLoyaltyCard() {
		return this.loyaltyCard;
	}
}