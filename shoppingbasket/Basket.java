package shoppingbasket;
import java.util.*;

public class Basket {
  ArrayList<Buyable> items;

  public Basket(){
    empty();
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
    return new ArrayList<Buyable>(this.items);
  }

}