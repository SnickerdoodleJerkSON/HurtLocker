import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexName {
    public static boolean checkForName(String input) {
        Pattern pattern = Pattern.compile("Name", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void main(String[] args) {
        String input = "Name";
        if (checkForName(input)) {
            System.out.println("Name");
        }
    }


}
