package bg.baradvance.repositories;

import bg.baradvance.interfaces.Repository;
import bg.baradvance.models.Order;

import java.util.HashMap;
import java.util.Map;

public class ExistingOrdersRepo implements Repository<Order, String> {


    private Map<String, Order> tableOrderMap;

    public ExistingOrdersRepo() {
        this.tableOrderMap = new HashMap<>();
    }

    @Override
    public void save(Order unit) {
        this.tableOrderMap.put(unit.getTableNumber(), unit);
    }

    @Override
    public Order remove(String tableNumber) {
        return this.tableOrderMap.remove(tableNumber);
    }

    @Override
    public Order fetch(String tableNumber) {
        return this.tableOrderMap.get(tableNumber);
    }

    @Override
    public boolean contains(String tableNumber) {
        return this.tableOrderMap.containsKey(tableNumber);
    }
}
