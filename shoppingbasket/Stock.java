package shoppingbasket;
import java.util.*;

public class Stock {
  ArrayList<Buyable> items;

  public Stock(ArrayList<Buyable> stock){
    this.items = new ArrayList<Buyable>(stock);
  }

  public ArrayList<Buyable> getItems(){
    return this.items;
  }
}