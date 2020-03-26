package bg.baradvance.repositories;

import bg.baradvance.interfaces.Repository;
import bg.baradvance.models.Order;

import java.util.HashMap;
import java.util.Map;

public class ExistingOrdersRepo implements Repository<Order,String> {

    Order order;
    Map<String, Order> tableOrderMap;

    public ExistingOrdersRepo(Order order) {
        this.order = order;
        this.tableOrderMap = new HashMap<>();
    }

    public ExistingOrdersRepo() {
        this.tableOrderMap = new HashMap<>();
    }

    public void set(String table){
        this.tableOrderMap.put(table,null);
    }

    @Override
    public void add(Order unit) {
        this.tableOrderMap.put(order.getTableNumber(),order);
    }

    @Override
    //will use the return Order-> to print the bill;
    public Order remove(String tableNumber) {
        return this.tableOrderMap.remove(tableNumber);
    }

    @Override
    public Order get(String tableNumber) {
        return this.tableOrderMap.get(tableNumber);
    }
}
