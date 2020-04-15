package wildanimals.mammals;

import wildanimals.foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getFoodQuantity();
    }

    @Override
    public String toString() {
        //Cat[Gray, Persian, 1.1, Home, 4]
       String catF = String.format("[%s, %s, %s, %s, %d]",this.animalName,this.breed,
                new DecimalFormat("#.##").format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);

        return this.getClass().getSimpleName() + catF;
    }
}
