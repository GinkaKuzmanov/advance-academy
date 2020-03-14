package comparator;

import java.util.Comparator;

public class TownComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getTown().compareToIgnoreCase(o2.getTown());
    }
}
