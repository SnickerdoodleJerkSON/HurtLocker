import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class GroceryListTest {

    public void testToString() {
        //Given
        Item item1 = new Item("Milk", 3.23, "Food", "12/23/2023");
        Item item2 = new Item("Bread", 1.23, "Food", "12/20/2023");
        String expected = item1.toString() + item2.toString();

        //when
        GroceryList grocery = new GroceryList();
        grocery.add(item1);
        grocery.add(item2);
        String actual = grocery.toString();

        //then what happens is
        Assert.assertEquals(expected, actual);
    }

    import java.util.Date;

    public class ItemListTest {
        //Given
        String expectedName = "Bread";
        double expectedPrice = 1.23;
        String expectedType = "Food";
        Date expectedExpiration = new Date("12/20/23");

        ItemList item = Item(expectedName, expectedPrice, expectedType,expectedExpiration);


    }


}
