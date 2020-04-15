package wildanimals.mammals;

import wildanimals.foods.Food;

public abstract class Animal {

    protected String animalName;
    protected double animalWeight;
    protected int foodEaten;

    protected Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);

}
