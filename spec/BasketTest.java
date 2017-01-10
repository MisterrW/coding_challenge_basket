import static org.junit.Assert.*;
import org.junit.*;
import shoppingbasket.*;

public class BasketTest {
  Sandwich sandwich;
  Sandwich sandwich2;
  Basket basket;
  
  @Before
  public void setup(){
    sandwich = new Sandwich("Ham", 2.99, false);
    sandwich2 = new Sandwich("Salmon", 3.60, false);
    basket = new Basket();
  }

  @Test
  public void testAddItem(){
    assertEquals(0, basket.getItems().size());
    basket.addItem(sandwich);
    assertEquals(1, basket.getItems().size());
  }

  @Test
  public void testRemoveItem(){
    basket.addItem(sandwich);
    basket.addItem(sandwich2);
    assertEquals(2, basket.getItems().size());
    Buyable returned = basket.removeItem(sandwich);
    assertEquals(1, basket.getItems().size());
    assertEquals("Ham", returned.getName());
  }

  @Test
  public void testTotalPrice(){
    basket.addItem(sandwich);
    basket.addItem(sandwich2);
    assertEquals(6.59, basket.getTotal(), 0.01);
  }

  @Test
  public void testTwoBogofItemsSameType(){
    basket.addItem(new Sandwich("Ham", 2.99, true));
    basket.addItem(new Sandwich("Salmon", 3.60, true));
    assertEquals(3.60, basket.applyBogofDiscount(), 0.01);
    assertEquals(2.99, basket.getBogofDiscount(), 0.01);
  }

  @Test
  public void testBogofBooleanWorks(){
    basket.addItem(new Sandwich("Ham", 2.99, true));
    basket.addItem(new Sandwich("Salmon", 3.60, false));
    basket.getTotal();
    assertEquals(6.59, basket.applyBogofDiscount(), 0.01);
    assertEquals(0, basket.getBogofDiscount(), 0.01);
  }

  @Test
  public void testCheapestItemDiscounted(){
    basket.addItem(new Sandwich("Egg", 1.20, true));
    basket.addItem(new Sandwich("Ham", 2.99, true));
    basket.addItem(new Sandwich("Salmon", 3.60, true));
    basket.getTotal();
    assertEquals(6.59, basket.applyBogofDiscount(), 0.01);
    assertEquals(1.20, basket.getBogofDiscount(), 0.01);
  }

  @Test
  public void testMultipleBogofMatches(){
    basket.addItem(new Sandwich("Egg", 1.20, true));
    basket.addItem(new Sandwich("Ham", 2.99, true));
    basket.addItem(new Sandwich("Salmon", 3.60, true));
    basket.addItem(new Sandwich("Pastrami", 5.00, true));
    assertEquals(8.60, basket.applyBogofDiscount(), 0.01);
    assertEquals(4.19, basket.getBogofDiscount(), 0.01);
  }

  @Test
  public void testMultipleBogofMatchesDifferentItemTypes(){
    basket.addItem(new Drink("Coke", 1.20, true));
    basket.addItem(new Drink("Fanta", 0.90, true));
    basket.addItem(new Sandwich("Salmon", 3.60, true));
    basket.addItem(new Sandwich("Pastrami", 5.00, true));
    assertEquals(6.20, basket.applyBogofDiscount(), 0.01);
    assertEquals(4.50, basket.getBogofDiscount(), 0.01);
  }

  @Test
  public void testTenPercentDiscount(){
    basket.addItem(new Drink("Prosecco", 15, false));
    assertEquals(basket.applyTenPercentDiscount(), 15, 0.1);
    basket.empty();
    basket.addItem(new Drink("Champagne", 30, false));
    assertEquals(basket.applyTenPercentDiscount(), 27, 0.1);
  }


}