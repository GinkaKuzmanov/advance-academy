package bg.baradvance.models;

public class Product {
    private String name;
    private String quantity;
    private double price;

    public Product(String name, String quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return price;
    }
}
