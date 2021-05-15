package step2;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StringOperation {

    private StringOperation() {}
    private static final class SingletonHelper {
        public static final StringOperation INSTANCE = new StringOperation();
    }
    public static StringOperation getInstance(){
        return SingletonHelper.INSTANCE;
    }

    private int calculateFourOperation(int a, int b, char operator){
        switch (operator){
            case '+': return add(a, b);
            case '-': return subtract(a, b);
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            default:
                throw new IllegalArgumentException();
        }
    }

    public int calculate(String input){
        if(input == null || input.equals("")) throw new IllegalArgumentException();

        int b = 0;
        char operator = ' ';
        int result = 0;

        List<String> operand = Arrays.asList(input.split(" "));

        for (int i = 0; i < operand.size()-2; i+=2){
            result = Integer.parseInt(operand.get(i));
            b = Integer.parseInt(operand.get(i+2));
            operator = operand.get(i+1).charAt(0);

            result = calculateFourOperation(result, b, operator);
        }
        return result;
    }

    private int add(final int a, final int b) {
        return a+b;
    }

    private int subtract(final int a, final int b) {
        return a-b;
    }

    private int multiply(final int a, final int b) {
        return a*b;
    }

    private int divide(final int a, final int b) {
        return a/b;
    }

}
