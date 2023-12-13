import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();

        List<String> parsedOutPut = ProductParser.parseProductLines(output);
        //parse method ##

        // raw date looks like this
        // //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##//naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##//naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##//naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##//naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##//naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##

        //paredOutPut
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,



        int errorCounter = 0;

        List<Product> listProduct = new ArrayList<>();

        for (String str : parsedOutPut) {
            Product product = new Product();
            //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,

            product.setName(ProductParser.extractNameFromProductLine(str));
            //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,
            //Setting a new name for the product. How do we get that product name?

            //product.setname("Milk");

            product.setPrice(ProductParser.extractPriceFromProductLine(str));

            product.setType(ProductParser.extractTypeFromProductLine(str));

            product.setExpiration(ProductParser.extractExpirationFromProductLine(str));

            //HashMap has a key and value.

            //Map<String, Map<String, Integer>>
            //milk -> milk - 3

            //     -> 3.25 - 2
            //     -> 3.42 - 2


            // Outter HashMap (1)
            // KEYs: " Milk'   "Bread"  "Cookies"   "Apples"
            // KEY and VALUE: INNER HASHMAP

            // PRICE, NAME - I want a counter for those.
            // Inner HashMap (2)


            if (product.getName() != null && product.getName().equals("Co0kieS")) {
                product.setName("cookies");
            }

            listProduct.add(product);
            if (product.getName() == null || product.getPrice() == null || product.getType() == null || product.getExpiration() == null) {
                errorCounter++;
            }
        }
        ProductParser.getCounter(listProduct);
        toFile();
    }

    public static void toFile() throws IOException {
        try {
            FileWriter file = new FileWriter("results.txt");

            file.write(ProductParser.stringMaker());
            file.close();

        } catch (IOException e) {

        }
    }
}



            // Milk, Bread, Cookies, Apples
            //  1      2      3        4


            //key 1 <- HashMap<Integer String>
            //The value can be any data structure, the key always has to be an object.

