package calculator;

public class InputInterpreter {

    private CalculationEngine engine;
    private CalculatorMemoryHandler memoryHandler;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memoryHandler = new CalculatorMemoryHandler();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        //engine.getCurrentResult(); push or pop
        //we will use the String to determine whether to call on pushing or popping

        if(input.equals("ms")){
            memoryHandler.saveCurrentResult(engine.getCurrentResult());
        }else if(input.equals("mr")){
            engine.pushNumber(memoryHandler.provideCurrentResult());
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }
        if(operation.equals("/")){
            return new DivisionOperation();
        }

        return null;

    }
}
