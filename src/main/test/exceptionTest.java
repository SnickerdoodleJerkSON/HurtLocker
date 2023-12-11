import org.junit.Assert;
import org.junit.Test;

public class exceptionTest {

    @Test
    public void testExceptionCount(){
        HurtLocker hurtLocker = new HurtLocker("name:;price:;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");
        Integer expected = 3;
        Assert.assertEquals(expected, hurtLocker.exceptionCount());

    }@Test
    public void testExceptionCount2(){
        HurtLocker hurtLocker = new HurtLocker("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");
        Integer expected = 0;
        Assert.assertEquals(expected, hurtLocker.exceptionCount());

    }
}
