package bg.baradvance.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Waiter waiter;
    private String tableNumber;
    private List<Product> chosenProducts;


    public Order(String tableNumber, Waiter waiter) {
        this.tableNumber = tableNumber;
        this.waiter = waiter;
        this.chosenProducts = new ArrayList<>();
    }

    public Order(String tableNumber, Waiter waiter, List<Product> chosenProducts) {
        this.tableNumber = tableNumber;
        this.chosenProducts = chosenProducts;
        this.waiter = waiter;

    }

    public String getTableNumber() {
        return tableNumber;
    }


    private double getTotalBill() {

        return this.chosenProducts.stream()
                .map(Product::getPrice).mapToDouble(d -> d).sum();
    }

    public String billMessage() {
        return String.format("You were served by: %s. Table: #%s. Owed sum is %.2f BGN."
                , this.waiter.getName(),
                this.getTableNumber()
                , this.getTotalBill());
    }


}
