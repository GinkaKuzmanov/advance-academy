package coffeeMachine;

public enum CoffeeSize {
    SMALL(50,50), NORMAL(100,75), DOUBLE(200,100);

    CoffeeSize(int dosage,int price){
        this.dosage = dosage;
        this.price = price;
    }
    private int dosage;
    private int price;

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
