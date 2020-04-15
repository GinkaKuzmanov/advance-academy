package wildanimals.mammals;

import wildanimals.foods.Food;
import wildanimals.foods.Meat;

public class Mouse extends Mammal {

    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            System.out.println("Mice are not eating that type of food!");
            return;
        }
        this.foodEaten += food.getFoodQuantity();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}
