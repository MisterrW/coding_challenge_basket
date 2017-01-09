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
  public void testTotalPrice(){
    basket.addItem(sandwich);
    basket.addItem(sandwich2);
    assertEquals(6.59, basket.getTotal(), 0.01);
  }


}