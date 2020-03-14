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
        int comparedValue = this.getName().compareToIgnoreCase(o.getName());
        if (comparedValue == 0) {
            return Integer.compare(this.getAge(), o.getAge());
        }
        if (this.getAge() - o.getAge() == 0) {
            return this.getTown().compareToIgnoreCase(o.getTown());
        }
        return comparedValue;
    }
}
