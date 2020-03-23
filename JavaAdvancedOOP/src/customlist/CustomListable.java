package customlist;

public interface CustomListable<T extends Comparable<T>> extends Printable<T> {

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int from, int to);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

}
