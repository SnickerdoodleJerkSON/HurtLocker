import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {
    public static String extractNameFromProductLine(String input) {
        String regexString = "[nN][aA][mM][eE]:([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String extractPriceFromProductLine(String input) {
        String regexString = "[pP][rR][iI][cC][eE]:([0-9]\\d*\\.?\\d+)"; // search numbers 0-9\allows for additional number\adds decimal\allows for additonal number after decimal
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String extractTypeFromProductLine(String input) {
        String regexString = "[tT][yY][pP][eE]:([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String extractExpirationFromProductLine(String input) {
        String regexString = "[eE][xX][pP][iI][rR][aA][tT][iI][oO][nN]:([0-9]\\d*/[0-31]\\d*/\\d{4})"; // [0-9]\d* <- month /[0-31]\d* <- date \\d{4}<- matches the year(four digits)
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static List<String> parseProductLines(String soureFile) {
        return null;
    }
}
