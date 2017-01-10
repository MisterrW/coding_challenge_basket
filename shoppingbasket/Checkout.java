package shoppingbasket;
import java.util.*;

public class Checkout {
  ArrayList<Buyable> bogofItems;
  double bogofDiscount;
  Basket basket;
  Shopper shopper;

  public Checkout(Basket basket, Shopper shopper){
    this.shopper = shopper;
    this.basket = basket;
  }

  public double getFinalTotal(){
    return applyLoyaltyCardDiscount();
  }

  public double applyLoyaltyCardDiscount(){
    double total = applyTenPercentDiscount();
    if(this.shopper.hasLoyaltyCard() == true) {
      total = total * 0.98;
    }
    return total;
  }

  public double applyTenPercentDiscount(){
    double total = applyBogofDiscount();
    if(total >= 20.0) {
      total = total * 0.9;
    }
    return total;
  }

  public double applyBogofDiscount(){
    double total = getTotal();
    createBogofArray(this.basket.getItems());
    calcBogofDiscount(this.bogofItems);
    total -= this.bogofDiscount;
    return total;
  }

  public double getTotal(){
    double total = 0;
    for(Buyable item : this.basket.getItems()){
      total += item.getPrice();
    }
    return total;
  }

  public void createBogofArray(ArrayList<Buyable> items){

    ArrayList<Buyable>bogofItems = new ArrayList<Buyable>(items);
    
    for (int i=0; i<bogofItems.size(); i++){
      if (bogofItems.get(i).checkBogof() == false){
        bogofItems.remove(i);
      }
    }

    bogofItems.sort(Comparator.comparing(Buyable::getPrice));
    Collections.reverse(bogofItems);
    this.bogofItems = bogofItems;
  }

  public void calcBogofDiscount(ArrayList<Buyable> bogofItems){
    this.bogofDiscount = 0.0;
    while(bogofItems.size() > 1){
      Buyable greater = bogofItems.get(0);
      bogofItems.remove(0);
      Boolean discountMatchedYet = false;
      for(int i=bogofItems.size()-1; i>=0; i--){
        if(discountMatchedYet == false){
          if(bogofItems.get(i).getClass() == greater.getClass()){
            this.bogofDiscount += bogofItems.get(i).getPrice();
            bogofItems.remove(i);
            discountMatchedYet = true;
          }
        }
      }
    }
  }

  public double getBogofDiscount(){
    return this.bogofDiscount;
  }

}