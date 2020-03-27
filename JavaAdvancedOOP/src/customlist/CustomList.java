package customlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>>
        implements CustomListable<T>,Iterable<T> {

    private List<T> items;

    public CustomList() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.items.add(element);

    }

    @Override
    public T remove(int index) {
        return this.items.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.items.contains(element);
    }

    @Override
    public void swap(int from, int to) {
        T el = this.items.get(to);
        this.items.set(to, this.items.get(from));
        this.items.set(from, el);


    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : this.items) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        return Collections.max(this.items);
    }

    @Override
    public T getMin() {
        return Collections.min(this.items);
    }

    @Override
    public void print() {
        for (T item : this.items) {
            System.out.println(item);
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.items);
        }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(items);
    }
}
