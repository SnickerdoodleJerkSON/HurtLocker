
import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;
import java.util.HashMap;

public class nameTest {

    @Test
    public void testNameMethod() {
        //Given
        String input = "Name";
        HashMap<String, String> foodNames = new HashMap<String, String>();
        //When
        Comparator<String> matches = input.CASE_INSENSITIVE_ORDER;
        // int occurrences = ?
        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testPriceMethod() {
        //Given
        String input = "Price";

        //When
        Comparator<String> matches = input.CASE_INSENSITIVE_ORDER;
        // int occurrences = ?
        //Then
        Assert.assertTrue(true);
    }


}