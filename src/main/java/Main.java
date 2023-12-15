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
        //Separates the RawData into a list to easily extract using the methods in ProductParser

        List<Product> listProduct = new ArrayList<>();
        //Used later to add all our products into

        for (String str : parsedOutPut) {
            Product product = new Product();

            product.setName(ProductParser.extractNameFromProductLine(str));
            product.setPrice(ProductParser.extractPriceFromProductLine(str));
            product.setType(ProductParser.extractTypeFromProductLine(str));
            product.setExpiration(ProductParser.extractExpirationFromProductLine(str));

            if (product.getName() != null && product.getName().equals("Co0kieS")) {
                product.setName("cookies");
                // used regex earlier to extract Co0kieS from RawData, setting it to the correct format to cookies.
            }
            listProduct.add(product);  // For each string we are creating a new product, adding all the products into ArrayList
        }
        ProductParser.getProductsAndCounter(listProduct);
        // Places products into a linkedHashMap
        toFile();
        // Write to a new file "results.txt" using the stringMaker method
    }

    public static void toFile() throws IOException {
        try {  //Writes an output file.
            FileWriter file = new FileWriter("results.txt");

            file.write(ProductParser.stringMaker());
            file.close();

        } catch (IOException e) {

        }
    }
}

