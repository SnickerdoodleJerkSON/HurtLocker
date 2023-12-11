import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {
    public static String extractNameFromProductLine(String input) {
        String regexString = "([nN][aA][mM][eE]:)[a-zA-Z]+;";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        for (int i = 0; matcher.find(); i++) {
            return matcher.group();
        }
        return null;
    }

    public static String extractPriceFromProductLine(String input) {
        return null;
    }

    public static String extractTypeFromProductLine(String input) {
        return null;
    }

    public static String extractExpirationFromProductLine(String input) {
        return null;
    }

    public static List<String> parseProductLines(String soureFile) {
        return null;
    }
}
