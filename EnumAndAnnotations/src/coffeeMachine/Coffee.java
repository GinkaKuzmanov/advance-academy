package coffeeMachine;

public class Coffee {
    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(CoffeeType type, CoffeeSize size) {
        this.type = type;
        this.size = size;
    }

    public int getPrice(){
       return this.size.getPrice();
    }


    @Override
    public String toString() {
        return "\"" + this.size.toString() + " " + this.type+"\"" + " " + "sold.";
    }
}
