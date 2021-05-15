package step2;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StringOperation {

    private StringOperation() {}
    private static class SingletonHelper {
        public static final StringOperation INSTANCE = new StringOperation();
    }
    public static StringOperation getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public static int add(final List<String> operand) {
        return operand.stream()
                .map(s -> s.charAt(0))
                .filter(Character::isDigit)
                .mapToInt(c -> c-'0')
                .reduce(0, Integer::sum);
    }

    public static int subtract(final List<String> operand) {
        return 0;
    }

    public static int multiply(final List<String> operand) {
        return 0;
    }

    public static int divide(final List<String> operand) {
        return 0;
    }


    public static int operate(final List<String> operand){
        return 0;
    }
}
