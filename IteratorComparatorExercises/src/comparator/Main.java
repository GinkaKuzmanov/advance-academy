package comparator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Person> people = new LinkedHashMap<>();
        int index = 0;
        String input;
        Person person;
        while (!"END".equals(input = reader.readLine())) {
            String[] lines = input.split("\\s+");
            String name = lines[0];
            int age = Integer.parseInt(lines[1]);
            String town = lines[2];
            person = new Person(name, age, town);
            people.put(++index, person);
        }
        int number = Integer.parseInt(reader.readLine());


        Person p1 = people.get(number); //person to compare
        Set<Person> sameness = new HashSet<>();
        Set<Person> diversity = new HashSet<>();

        for (Person value : people.values()) {
            if (people.containsKey(number)) {
                if (new NameComparator().compare(p1, value) == 0 && new AgeComparator().compare(p1, value) == 0
                        && new TownComparator().compare(p1, value) == 0) {
                    sameness.add(value);
                }
                if (new NameComparator().compare(p1, value) != 0 || new AgeComparator().compare(p1, value) != 0
                        || new TownComparator().compare(p1, value) != 0) {
                    diversity.add(value);
                }
            } else {
                System.out.println("No matches");
            }
        }
        if (sameness.size() - diversity.size() == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(sameness.size() + " " + diversity.size() + " " + people.size());
        }
    }
}

