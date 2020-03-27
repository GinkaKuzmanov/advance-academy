package bg.baradvance.repositories;

import bg.baradvance.models.Waiter;

import java.util.*;


public class WaiterData {
//DATA FOR WAITERS

    List<Waiter> waiters = new ArrayList<>();

    private Waiter waiter = new Waiter("Ginka", "5555");
    private Waiter waiter1 = new Waiter("Ivan", "6666");
    private Waiter waiter2 = new Waiter("Maria", "1111");

    public WaiterData() {
        Collections.addAll(waiters, waiter, waiter1, waiter2);
    }

    public List<Waiter> getWaiters() {
        return this.waiters;
    }
}
