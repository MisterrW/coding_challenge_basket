package shoppingbasket;

public class Runner {
  private Shopper shopper;
  private Basket basket;
  private Checkout checkout;
  private Stock stock;

  public Runner(){
    this.basket = new Basket();
  }

  public void run(){
    String name = getName();
    pause();

    boolean loyalty = getLoyalty();
    pause();

    this.shopper = new Shopper(name, loyalty, basket);
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
    Thread.sleep(700);
    } 
    catch(InterruptedException e){
    }
  }
}
