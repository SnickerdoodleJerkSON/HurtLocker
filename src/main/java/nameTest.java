
import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;

public class nameTest {

    @Test
    public void testNameMethod() {
        //Given
        String input = "Name";

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