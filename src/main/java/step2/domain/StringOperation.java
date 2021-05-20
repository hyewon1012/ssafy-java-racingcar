package step2.domain;

import step2.strategy.*;

import java.util.*;

public final class StringOperation {
    private static final int INITIAL_NUMBER = 0;

    public static final StringOperation getInstance(){
        return SingletonHelper.INSTANCE;
    }

    private static final class SingletonHelper {
        public static final StringOperation INSTANCE = new StringOperation();
    }

    private StringOperation() {}

    private static final String BLANK = " ";
    private static final int FIRST_INDEX = 0;

    public int calculate(String input){
        validateEmpty(input);

        StringTokenizer stringTokenizer = new StringTokenizer(input, BLANK);
        final List<Integer> operand = new ArrayList<>();
        final List<String> operator = new ArrayList<>();

        operand.add(Integer.parseInt(stringTokenizer.nextToken()));
        while(stringTokenizer.hasMoreTokens()){
            operator.add(stringTokenizer.nextToken());
            operand.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return operator(operand, operator);
    }

    public static void validateEmpty(String input){
        Optional<String> optionalInput = Optional.ofNullable(input);
        optionalInput.orElseThrow(() -> new IllegalArgumentException());

        if(optionalInput.get().length() == 0){
            throw new IllegalArgumentException();
        }
    }

    private int operator(List<Integer> operand, List<String> operator) {
        int result = operand.get(FIRST_INDEX);
        operand.remove(FIRST_INDEX);
        for (int i = FIRST_INDEX; i < operator.size(); i++){
            String op = operator.get(i);

            Operation operation = Operation.match(op);
            result = operation.apply(result, operand.get(i));
        }
        return result;
    }




}
