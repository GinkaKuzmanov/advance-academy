package exercises.P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<E extends Comparable<E>> extends ArrayList<E> {

    public E min() {
        E min = this.get(0);
        Iterator<E> iterator = super.iterator();

        while(iterator.hasNext()){
            E next = iterator.next();
            if(min.compareTo(next) > 0){
                min = next;
            }
        }
        return min;
    }

    public E max(){
        E max = this.get(0);
        Iterator<E> iterator = super.iterator();

        while(iterator.hasNext()){
            E next = iterator.next();
            if(max.compareTo(next) < 0){
                max = next;
            }
        }
        return max;
    }

}
