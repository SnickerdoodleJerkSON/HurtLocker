
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class nameTest {

    @Test
    public void testExtractNameFromProductLine() {
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"; // string i am searching through. I'm trying to find word 'milk'
        String expected = "Milk";
        //When
        String name = ProductParser.extractNameFromProductLine(input);
        //Then
        Assert.assertEquals(expected, name);

    }

    @Test
    public void testExtractPriceFromProductLine() {
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"; // string i am searching through. I'm trying to find word 'milk'
        String expected = "3.23";
        //When
        String price = ProductParser.extractPriceFromProductLine(input);
        //Then
        Assert.assertEquals(expected, price);

    }

    @Test
    public void testExtractTypeFromProductLine() {
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"; // string i am searching through. I'm trying to find word 'milk'
        String expected = "Food";
        //When
        String type = ProductParser.extractTypeFromProductLine(input);
        //Then
        Assert.assertEquals(expected, type);

    }

    @Test
    public void testExtractExpirationFromProductLine() {
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"; // string i am searching through. I'm trying to find word 'milk'
        String expected = "1/25/2016";
        //When
        String expiration = ProductParser.extractExpirationFromProductLine(input);
        //Then
        Assert.assertEquals(expected, expiration);

    }

    // Test Product Constructor
    @Test
    public void testProductConstructor() {
        //Given
        Object product = new Product();
        Assert.assertTrue(product instanceof Product);
    }
    //Name
    @Test
    public void testSetProductName() {
        Product product = new Product();
        String name = "Milk";
        product.setName(name);
        Assert.assertEquals(name, product.getName());
    }

    @Test
    public void testSetProductPrice() {
        Product product = new Product();
        Double price = 3.23;
        product.setPrice(price);
        Assert.assertEquals(price, product.getPrice());
    }

    @Test
    public void testSetProductType() {
        Product product = new Product();
        String type = "Food";
        product.setType(type);
        Assert.assertEquals(type, product.getType());
    }

    @Test
    public void testSetProductExpiration() {
        Product product = new Product();
        String expiration = "1/25/2016";
        product.setExpiration(expiration);
        Assert.assertEquals(expiration, product.getExpiration());
    }

    @Test
    public void testProductLineParse() {
        String soureFile = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        List<String>productLines = ProductParser.parseProductLines(soureFile);
        Assert.assertEquals(28, productLines.size());
    }

    // setname

    // Price
    // setname
    // get name

    // Type
    // setname
    // get name

    // Expiration
    // setname
    // get name

}