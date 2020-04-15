package wildanimals;

import wildanimals.foods.Food;
import wildanimals.foods.Meat;
import wildanimals.foods.Vegetable;
import wildanimals.mammals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mammal animal = null;
        Food foods = null;
        List<Mammal> animalsList = new ArrayList<>();
        String input = "";

        //INPUT:!!!
        //Tiger Tom 167.7 Asia
        //Vegetable 1
        //End
        while (!"End".equals(input = scanner.nextLine())) {
            String[] lines = input.split("\\s+");
            if (lines.length == 2) {
                if (lines[0].equals("Vegetable")) {
                    foods = new Vegetable(Integer.parseInt(lines[1]));
                } else if (lines[0].equals("Meat")) {
                    foods = new Meat(Integer.parseInt(lines[1]));
                }
                assert animal != null;
                animal.eat(foods);
            } else {
                switch (lines[0]) {
                    case "Cat":
                        animal = new Cat(lines[1], Double.parseDouble(lines[2]),
                                lines[3], lines[4]);
                        break;
                    case "Tiger":
                        animal = new Tiger(lines[1], Double.parseDouble(lines[2]),
                                lines[3]);
                        break;
                    case "Mouse":
                        animal = new Mouse(lines[1], Double.parseDouble(lines[2]),
                                lines[3]);
                        break;
                    case "Zebra":
                        animal = new Zebra(lines[1], Double.parseDouble(lines[2]),
                                lines[3]);
                        break;

                }
                assert animal != null;
                animal.makeSound();
                animalsList.add(animal);
            }
        }
        animalsList.forEach(System.out::println);

    }
}
