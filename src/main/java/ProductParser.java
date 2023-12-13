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
            // <- String regexString2 = "";
         // <- GROUP - a-ZA-Z
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
        String regexString = "expiration:([^a-zA-Z:%@#^*;]+)";
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


    public static Map<String,Map<String,Integer>> getCounter(List<Product> values){
        //milk // bread // cookkies  //apples

        mapList = new LinkedHashMap<>();
        // OUTER HASH MAP
        // Key: grocery name
        // Value: (INNER HASH MAP) -> Map<String,Integer>
            // milk: 1,
            // 3.23: 1,
            // 2.22: 1,

        int counter = 0;
        for (Product p : values) {

            if ((p.getName() != null) && (p.getPrice() != null)) {
                // so all the Products in the List<Product> values
                if (!mapList.containsKey(p.getName().toLowerCase())) {
                    //if it does  not exist, we put into the innerMap
                    Map<String, Integer> innerMap = new LinkedHashMap<>();
                    mapList.put(p.getName().toLowerCase(), innerMap);
                }
                Map<String, Integer> innerMap = mapList.get(p.getName().toLowerCase());
                innerMap.compute(p.getName().toLowerCase(), (key, value) -> (value == null) ? 1 : value + 1);
                // Lambda expression using compute method to see to if the value to the corresponding key exists,
                // If the value doesn't exist, then you do a put for that key and value of 1, if it exists then +1 the value
                    innerMap.compute(p.getPrice().toString(), (key, value) -> (value == null) ? 1 : value + 1);
            } else {
                if (!mapList.containsKey("Error")) {
                    //if it does  not exist, we put into the innerMap
                    Map<String, Integer> innerMap = new LinkedHashMap<>();
                    mapList.put("Error", innerMap);
                }
                Map<String, Integer> innerMap = mapList.get("Error");
                innerMap.compute("Error", (key, value) -> (value == null) ? 1 : value + 1);
            }
        } return mapList;
    }


    public static String stringMaker(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String,Integer>> entry : mapList.entrySet()) {
            Map<String,Integer> innerMap  = entry.getValue();

            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                if(!innerEntry.getKey().contains(".") && !innerEntry.getKey().equals("Error")) {
                    result.append("   \n" + "Name:   " + innerEntry.getKey() + "    \t " + "seen: " + innerEntry.getValue() + " times" + "\n=============" + "\t\t ============");
                } else if (innerEntry.getKey().contains(".")) {
                    result.append("   \n" + "Price:   " + innerEntry.getKey() + "    \t " + "seen: " + innerEntry.getValue() + " times" + "\n-------------" + "\t\t -------------");
                } else {
                    result.append("\n" + innerEntry.getKey() +  "                seen: " + innerEntry.getValue() + " times");
                }
            }
        }
        return result.toString();
    }
}
