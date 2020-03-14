package comparator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String input;
        Person person = null;
        while (!"END".equals(input = reader.readLine())) {
            String[] lines = input.split("\\s+");
            String name = lines[0];
            int age = Integer.parseInt(lines[1]);
            String town = lines[2];
            person = new Person(name, age, town);
            people.add(person);
        }
        int number = Integer.parseInt(reader.readLine());
        int chosenOne = number - 1;

//        if (chosenOne == people.size()) {
//            chosenOne--;
//        }
        Person personToCompare = people.get(chosenOne);
        int sameness = 0;
        int diversity = 0;
        for (int i = 0; i < people.size(); i++) {
            if (personToCompare == people.get(i)) {
                sameness++;
                continue;
            }
            if (new NameComparator().compare(personToCompare, people.get(i)) != 0 ||
                    new AgeComparator().compare(personToCompare, people.get(i)) != 0 || new TownComparator().compare(personToCompare, people.get(i)) != 0) {
                diversity++;
            } else if (new NameComparator().compare(personToCompare, people.get(i)) == 0 &&
                    new AgeComparator().compare(personToCompare, people.get(i)) == 0 && new TownComparator().compare(personToCompare, people.get(i)) == 0) {
                sameness++;
            }


        }
        if (diversity == 1 && sameness == 0) {
            System.out.println("No matches");
        } else if (sameness - diversity == 0) {
            System.out.println("No matches");
        } else {
            System.out.print(sameness + " ");
            System.out.print(diversity + " ");
            System.out.print(people.size());
        }
    }
}
