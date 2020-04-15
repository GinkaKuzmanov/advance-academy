package wildanimals.mammals;

import wildanimals.foods.Food;
import wildanimals.foods.Meat;

public class Zebra extends Mammal {

    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Zebras are not eating that type of food!");
            return;
        }
        this.foodEaten += food.getFoodQuantity();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}
