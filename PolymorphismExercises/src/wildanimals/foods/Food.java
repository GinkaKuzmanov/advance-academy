package wildanimals.foods;

public abstract class Food {
    protected int foodQuantity;

    public Food(int foodQuantity){
        this.foodQuantity = foodQuantity;
    }

    public int getFoodQuantity() {
        return this.foodQuantity;
    }
}
