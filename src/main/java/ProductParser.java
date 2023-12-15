import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {

    static Map<String, Map<String,Integer>> mapList;
    public ProductParser() {
        this.mapList = new LinkedHashMap<>();
    }

    public static String extractNameFromProductLine(String input) {
        String regexString = "[nN][aA][mM][eE]:([a-zA-Z0]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static Double extractPriceFromProductLine(String input) {
        String regexString = "[pP][rR][iI][cC][eE]:([^a-zA-Z:%@^*;]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            return Double.valueOf(matcher.group(1));
        }
        return null;
    }

    public static String extractTypeFromProductLine(String input) {
        String regexString = "[tT][yY][pP][eE]:([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static String extractExpirationFromProductLine(String input) {
        String regexString = "[eE][xX][pP][iI][rR][aA][tT][iI][oO][nN]:([^a-zA-Z:%@#^*;]+)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static List<String> parseProductLines(String sourceFile) {
        return Arrays.asList(sourceFile.split("##"));
    }

    public static Map<String,Map<String,Integer>> getProductsAndCounter(List<Product> values){

        mapList = new LinkedHashMap<>();
        // OUTER HASH MAP
        // Key: product name (Milk, Bread, Cookies, Apples)

        // Value: (INNER HASH MAP) -> Map<String,Integer>
            // (INNER KEY) milk: 1,
            // (INNER KEY) 3.23: 1,
            // (INNER KEY) 1.23: 1,

        for (Product p : values) {

            if ((p.getName() != null) && (p.getPrice() != null)) {
                // so all the Products in the List<Product> values that are not null values (these are errors if null)
                if (!mapList.containsKey(p.getName().toLowerCase())) {
                    //If OUTTER map doesn't contain key, we want to create a key/value pair, the key is our name (product name)
                                                                            //the value is our INNER MAP.
                    // toLowerCase is to account for all the different spellings

                    Map<String, Integer> innerMap = new LinkedHashMap<>();
                    mapList.put(p.getName().toLowerCase(), innerMap);
                }
                Map<String, Integer> innerMap = mapList.get(p.getName().toLowerCase());
                // Getting back the map value that is associated to our key, which is the INNER LinkedHashMap.
                innerMap.compute(p.getName().toLowerCase(), (key, value) -> (value == null) ? 1 : value + 1);
                // Lambda expression using compute method to see to if the value to the corresponding key exists,
                // If the value doesn't exist, then you do a put for that key and value of 1, if it exists then +1 the value
                innerMap.compute(p.getPrice().toString(), (key, value) -> (value == null) ? 1 : value + 1);
            } else {
                if (!mapList.containsKey("Errors")) {
                    //if it does not exist, we put into the innerMap
                    Map<String, Integer> innerMap = new LinkedHashMap<>();
                    mapList.put("Errors", innerMap);
                } //Keeping track of errors with products that have no name or price.
                // (for keys have that have no values)
                Map<String, Integer> innerMap = mapList.get("Errors");
                innerMap.compute("Errors", (key, value) -> (value == null) ? 1 : value + 1);
            }
        } return mapList;
    }

    public static String stringMaker(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String,Integer>> entry : mapList.entrySet()) {
            Map<String,Integer> innerMap  = entry.getValue();

            //Trying to build similar string format to output.txt

            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {

                if(!innerEntry.getKey().contains(".") && !innerEntry.getKey().equals("Errors")) {
                    result.append("name:   " + innerEntry.getKey().substring(0,1).toUpperCase()
                            + innerEntry.getKey().substring(1)
                            +  "\t\t" + "seen: "
                            + innerEntry.getValue()
                            + " times" + "\n============="
                            + "\t\t=============");
                } else if (innerEntry.getKey().contains(".")) {
                    result.append("   \n" + "Price:   " + innerEntry.getKey()
                            + "    \t" + "seen: "
                            + innerEntry.getValue()
                            + " times" + "\n-------------"
                            + "\t\t-------------");
                } else {
                    //this appends the errors and numbers of errors in the RawData.txt
                    result.append(innerEntry.getKey() +  "         \t \tseen: " + innerEntry.getValue() + " times");
                }
            }
            result.append("\n\n");
        }
        return result.toString();
    }

    String outputText = "name:    Milk \t\t seen: 6 times\n" +
            "============= \t \t =============\n" +
            "Price: \t 3.23\t\t seen: 5 times\n" +
            "-------------\t\t -------------\n" +
            "Price:   1.23\t\t seen: 1 time\n" +
            "\n" +
            "name:   Bread\t\t seen: 6 times\n" +
            "=============\t\t =============\n" +
            "Price:   1.23\t\t seen: 6 times\n" +
            "-------------\t\t -------------\n" +
            "\n" +
            "name: Cookies     \t seen: 8 times\n" +
            "=============     \t =============\n" +
            "Price:   2.25        seen: 8 times\n" +
            "-------------        -------------\n" +
            "\n" +
            "name:  Apples     \t seen: 4 times\n" +
            "=============     \t =============\n" +
            "Price:   0.25     \t seen: 2 times\n" +
            "-------------     \t -------------\n" +
            "Price:   0.23  \t \t seen: 2 times\n" +
            "\n" +
            "Errors         \t \t seen: 4 times\n";
}
