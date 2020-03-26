package bg.baradvance.repositories;

import bg.baradvance.models.Waiter;

import java.util.*;


public class WaiterRepositories {


    List<Waiter> waiters = new ArrayList<>();

    private Waiter waiter = new Waiter("Ginka", "5555");
    private Waiter waiter1 = new Waiter("Ivan", "6666");
    private Waiter waiter2 = new Waiter("Maria", "1111");

    public WaiterRepositories() {
        Collections.addAll(waiters, waiter, waiter1, waiter2);
    }

    public void addWaiter(Waiter waiterLoad) {
        this.waiters.add(waiterLoad);
    }


    public  List<Waiter> getWaiters() {
        return this.waiters;
    }
}
