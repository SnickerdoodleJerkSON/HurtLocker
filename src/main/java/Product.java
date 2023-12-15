public class Product {
    String name;
    Double price;
    String type;
    String expiration;

    public Product() {
        //Nullary constructor
        this.name = "";
        this.price = 0.00;
        this.type  = "";
        this.expiration = "";
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    public String getExpiration() {
        return this.expiration;
    }
}
