package shoppingbasket;
import java.util.*;

public class Runner {
  private Shopper shopper;
  private Basket basket;
  private Checkout checkout;
  private Stock stock;
  
  public Runner(){
    this.basket = new Basket();
    ArrayList<Buyable> stockPrimer = new ArrayList<Buyable>();
    
    stockPrimer.add(new Drink("Coke", 1.20, true));
    stockPrimer.add(new Drink("Fanta", 0.90, true));
    stockPrimer.add(new Sandwich("Salmon", 3.60, true));
    stockPrimer.add(new Sandwich("Pastrami", 5.00, true));
    stockPrimer.add(new Drink("Prosecco", 15, false));
    
    this.stock = new Stock(stockPrimer);
  }
  
  public void run(){
    String name = getName();
    pause();

    boolean loyalty = getLoyalty();
    pause();

    this.shopper = new Shopper(name, loyalty);

    showStock();
  }

  public boolean getLoyalty(){
    boolean loyalty = false;
    System.out.println("If you have a loyalty card, please enter your code. Otherwise, just press 'enter'.");
    String code = System.console().readLine();
    if(code != null){
      if(code.equals("DEAL")){
        loyalty = true;
        System.out.println("Code accepted.");
      } else {
        System.out.println("Sorry, code not recognised.");
      }
    }
    return loyalty;
  }

  public String getName(){
    System.out.println("Hello! Welcome to the shop. What's your name?");
    return System.console().readLine();
  }

  public void pause(){
    try {
    Thread.sleep(1000);
    } 
    catch(InterruptedException e){
    }
  }

  public void showStock(){
    System.out.println("These items are available:");
    for (Buyable item : this.stock.getItems()) {
      System.out.println(String.format(item.getName() + ", £" + item.getPrice()));
    }
  }
}
