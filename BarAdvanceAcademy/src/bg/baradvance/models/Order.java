package bg.baradvance.models;

import java.util.Collections;
import java.util.List;

public class Order {

    private Waiter waiter;
    private String tableNumber;
    private List<Product> chosenProducts;


    public Order(){
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setChosenProducts(List<Product> products) {
        this.chosenProducts = products;
    }


    public void addToExistingOrder(Product... products){
        Collections.addAll(this.chosenProducts,products);
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
