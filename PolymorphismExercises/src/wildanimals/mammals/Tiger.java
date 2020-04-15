package wildanimals.mammals;

import wildanimals.foods.Food;
import wildanimals.foods.Vegetable;

public class Tiger extends Felime {

    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            System.out.println("Tigers are not eating that type of food!");
            return;
        }
        this.foodEaten += food.getFoodQuantity();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}
