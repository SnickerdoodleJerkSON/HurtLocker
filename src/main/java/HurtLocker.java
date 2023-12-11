import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HurtLocker {
    private String item;

    public HurtLocker(String grocery) {
        item = grocery;
    }

    public HashMap priceFinder(String str, String pattern) {

        Matcher matcher = Pattern.compile(str, Pattern.CASE_INSENSITIVE).matcher(pattern);
        // Matcher object to use parameter "str" applying to "pattern" string
        HashMap<String, Integer> prices = new HashMap<String, Integer>();
        // Using the HashMap to find the keys (numerical value in string) to count the number of occurences
        while (matcher.find()) {
            //Loop through the matches found by the matcher object
            Matcher priceMatch = Pattern.compile("[0-9]*\\.[0-9]+").matcher(matcher.group());
            // regex for number values including  "."
            if (priceMatch.find()) {
                // put the numerical value to a String price
                String price = priceMatch.group();
                if (prices.containsKey(price)) {
                    prices.put(price, prices.get(price) + 1);
                    // increment count if value is found
                } else {
                    prices.put(price, 1);
                    // if not found, add a new entry to the HashMap
                }
            }
        }
        return prices;
    }

    public Integer countPrices(HashMap<String, Integer> prices) {
        // counter for each food item -> number appearances for a price
        int counter = 0;
        for (String p : prices.keySet()) {
            counter += prices.get(p);
        } //
        return counter;
    }

    public Integer exceptionCount() {  // exceptions for empty names and prices for items
        int counter = 0;
        Matcher match = Pattern.compile("(n..e:[^a-zA-Z])|(;p...e:[^0-9])").matcher(item);
        while (match.find()){                // name : DOES NOT FOLLOW A LETTER AFTER
                                                // OR price: DOES NOT FOLLOW A NUMBER AFTER
            counter++;
        }
        return counter;   //returns the number of exceptions that have empty names and prices after
    }

}

