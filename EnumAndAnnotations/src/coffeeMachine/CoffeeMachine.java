package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeeList;
    private int money;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = Enum.valueOf(CoffeeSize.class,size.toUpperCase());
        CoffeeType coffeeType = Enum.valueOf(CoffeeType.class,type.toUpperCase());
        Coffee coffee = new Coffee(coffeeType,coffeeSize);
        if (coffee.getPrice() <= this.money){
            this.coffeeList.add(coffee);
            this.money = 0;
        }


    }

    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin).getValue();
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }
}
