import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StackIterator implements Iterable<Integer> {
    private List<Integer> stack;
    int index = 0;

    public StackIterator() {
        this.stack = new ArrayList<>();
    }

    public void push(Integer integer){
        this.stack.add(integer);
    }
    public Integer peek(){
        return this.stack.get(stack.size() - 1);
    }

    public Integer pop(){
        if(!stack.isEmpty()) {
            return this.stack.remove(stack.size() - 1);
        }else {
            throw new UnsupportedOperationException("No elements");
        }
    }

    public boolean isEmpty(){
        return this.stack.size() == 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StrIter();
    }

    private final class StrIter implements Iterator<Integer>{

        @Override
        public boolean hasNext() {
            return index < stack.size();
        }

        @Override
        public Integer next() {
            return stack.get(index++);
        }

    }
}
