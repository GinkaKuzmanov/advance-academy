package calculator;

public final class ArithmeticOperations {

    private ArithmeticOperations() {
    }

    public static double additionTwoNumbers(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public static double subtractTwoNumbers(double firstOperand, double secondOperand) {
       // double minuend = Math.max(firstOperand, secondOperand);
       // double subtrahend = Math.min(firstOperand, secondOperand);
        return firstOperand - secondOperand;
    }

    public static double multiplyTwoNumbers(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public static double divideTwoNumbers(double firstOperand, double secondOperand) {
        //double dividend = Math.max(firstOperand, secondOperand);
        //double divisor = Math.min(firstOperand, secondOperand);
        return firstOperand / secondOperand;

    }

}
