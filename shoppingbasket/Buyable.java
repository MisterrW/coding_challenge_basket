package shoppingbasket;

public abstract class Buyable {
  private String name;
  private double price;
  private boolean bogof;

  public Buyable(String name, double price, boolean bogof){
    this.name = name;
    this.price = price;
    this.bogof = bogof;
  }
  
  public String getName(){
    return this.name;
  }

  public double getPrice(){
    return this.price;
  }

  public boolean checkBogof(){
    return this.bogof;
  }
}