import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    @Test
    public void AppleTest(){
        HurtLocker hurtLocker = new HurtLocker("name:milk; price:2.42; name:24;price:milk;name:apple;name:aPPlE;name:Apple");
        Integer expected = 3;
        Assert.assertEquals(expected, hurtLocker.countApples());
    }
}
