public class Product {
    String name;
    Double price;
    String type;
    String expiration;

    public Product(){
        this.name = name;
        this.price = price;
        this.type  = type;
        this.expiration = expiration;
    }
    public void setName(String name) {
        this.name = name;
        //Pet Collections, Pet, Dogs, Cats

        //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##,

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
