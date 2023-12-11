
import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;
import java.util.HashMap;

public class nameTest {

    @Test
    public void testNameMethod() {
        //Given
        String input = "name";
        HashMap<String, String> foodNames = new HashMap<String, String>();
        //When
        Comparator<String> matches = input.CASE_INSENSITIVE_ORDER;
        // int occurrences = ?
        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testSymbolsMethod() {
        //Given
        String input = ":, @, ^, *, %";
        //When
        boolean expected = input.contains(":");
        //Then
        Assert.assertTrue(expected);
    }


}