package shoppingbasket;
import java.util.*;

public class Basket {
  ArrayList<Buyable> items;
  ArrayList<Buyable> bogofItems;
  double bogofDiscount;
  Boolean hasLoyaltyCard;

  public Basket(){
    this.items = new ArrayList<Buyable>();
  }

  public void empty(){
    this.items = new ArrayList<Buyable>();
  }

  public void addItem(Buyable item){
    this.items.add(item);
  }

  public Buyable removeItem(Buyable toRemove){
    for(int i=0; i<this.items.size(); i++) {
      if(this.items.get(i).getName().equals(toRemove.getName())){
        return this.items.remove(i);
      }
    }
    return null;
  }

  public ArrayList<Buyable> getItems(){
    ArrayList<Buyable> currentItems = new ArrayList<Buyable>(this.items);
    return currentItems;
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
    createBogofArray(this.items);
    calcBogofDiscount(this.bogofItems);
    total -= this.bogofDiscount;
    return total;
  }

  public double getTotal(){
    double total = 0;
    for(Buyable item : this.items){
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

    bogofItems.sort(Comparator.comparing(Buyable::getPrice);
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