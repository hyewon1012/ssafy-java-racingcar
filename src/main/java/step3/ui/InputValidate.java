package step3.ui;

import java.util.Objects;

public class InputValidate {
    private static final int EMPTY_LENGTH = 0;
    private final String input;

    public InputValidate(final String input){
        validateInput(input);
        this.input = input;
    }

    public static void validateInput(final String input){
        if(Objects.isNull(input) || input.isEmpty() || input.length() == EMPTY_LENGTH){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if(Integer.parseInt(input) < 1){
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

    public int getInput(){
        return Integer.parseInt(this.input);
    }
}
