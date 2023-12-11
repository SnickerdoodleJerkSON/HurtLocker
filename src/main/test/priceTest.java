import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class priceTest {
    HurtLocker foods;
    HashMap<String,Integer> map;


    @Before
    public void setUp() {
        foods = new HurtLocker("");
    }


    @Test
    public void priceCountTest() {
        map = foods.priceFinder("3.23", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");

        int expected = 2;
        int actual = foods.countPrices(map);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void priceFinderTest(){
        map = foods.priceFinder("3.23", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");

        Integer expected = 2;
        Assert.assertEquals(expected, map.get("3.23"));
    }
}
