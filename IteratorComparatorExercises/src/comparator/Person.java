package comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.compareToIgnoreCase(o.name) != 0)
        {
            return this.name.compareToIgnoreCase(o.name);
        }

        if(this.age != o.age)
        {
            return this.age - o.age;
        }

        return this.town.compareToIgnoreCase(o.town);
    }


}
