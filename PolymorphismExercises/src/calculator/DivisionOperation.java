package calculator;

import java.util.ArrayList;
import java.util.List;

public class DivisionOperation implements Operation {
    //list of operands -> int
    //int of result
    private List<Integer> operands;
    private int result;

    public DivisionOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0) / this.operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        //има ли достатъчно числа за калкулиране
        return this.operands.size() == 2;
    }
}
