import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        int errorCounter = 0;

        List<Product> listProduct = new ArrayList<>();

        for (String str : parsedOutPut) {
            Product product = new Product();

            product.setName(ProductParser.extractNameFromProductLine(str));
            product.setPrice(ProductParser.extractPriceFromProductLine(str));
            product.setType(ProductParser.extractTypeFromProductLine(str));
            product.setExpiration(ProductParser.extractExpirationFromProductLine(str));


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

