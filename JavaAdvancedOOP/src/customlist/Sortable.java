package customlist;

import java.util.Collection;

public interface Sortable<T extends Comparable<T>> {

    void sort();

}
