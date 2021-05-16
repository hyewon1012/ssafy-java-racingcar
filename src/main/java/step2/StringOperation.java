package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StringOperation {
    private static final int INITIAL_NUMBER = 0;
    
    public static final StringOperation getInstance(){
        return SingletonHelper.INSTANCE;
    }

    private static final class SingletonHelper {
        public static final StringOperation INSTANCE = new StringOperation();
    }

    private StringOperation() {}

    private int calculateFourOperation(int x, int y, char operator){
        if(operator == '+'){
            return add (x,y);
        }
        if(operator == '-'){
            return subtract (x,y);
        }
        if(operator == '*'){
            return multiply (x,y);
        }
        if(operator == '/'){
            return divide (x,y);
        }
        throw new IllegalArgumentException();
    }

    public int calculate(String input){
        validateEmpty(input);

        int y = INITIAL_NUMBER;
        char operator = ' ';
        List<String> operand = Arrays.asList(input.split(" "));
        int result = Integer.parseInt(operand.get(0));

        for (int i = 0; i < operand.size()-2; i+=2){
            operator = operand.get(i+1).charAt(0);
            y = Integer.parseInt(operand.get(i+2));
            result = calculateFourOperation(result, y, operator);
        }
        return result;
    }

    public void validateEmpty(String input){
        if(Objects.isNull(input) || input.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private int add(final int x, final int y) {
        return x+y;
    }

    private int subtract(final int x, final int y) {
        return x-y;
    }

    private int multiply(final int x, final int y) {
        return x*y;
    }

    private int divide(final int x, final int y) {
        return x/y;
    }

}
