package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorMemoryHandler {

    private final Deque<Integer> calculations;

    public CalculatorMemoryHandler(){
        this.calculations = new ArrayDeque<>();
    }

    //need to implement a static method which saves into the deque
    public void saveCurrentResult(int result){
        this.calculations.push(result);
    }
    // need to implement a method that retrieve the result when the string is received

    public int provideCurrentResult(){
        if(!this.calculations.isEmpty()){
            return this.calculations.pop();
        }
        return 0;
    }
}
