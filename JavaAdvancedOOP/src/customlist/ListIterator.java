package customlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator<T> implements Iterator<T> {

    private List<T> elements;
    private int nextIndex;

    public ListIterator(List<T> els){
        this.elements = els;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return this.nextIndex < this.elements.size();
    }

    @Override
    public T next() {
        return this.elements.get(nextIndex++);
    }
}
