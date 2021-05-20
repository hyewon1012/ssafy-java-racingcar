package step2.domain;

import step2.strategy.Calculator;

import java.util.Arrays;

public enum Operation {
    ADDITION("+", (x, y) -> Math.addExact(x, y)),
    SUBTRACTION("-", (x,y) -> Math.subtractExact(x,y)),
    MULTIPLICATION("*", (x,y) -> Math.multiplyExact(x,y)),
    DIVIDE("/", (x,y) -> Math.floorDiv(x,y));

    private final String operation;
    private final Calculator calculator;

    Operation(final String operation, final Calculator calculator){
        this.operation = operation;
        this.calculator = calculator;
    }

    public static Operation match(final String op){
        return Arrays.stream(values())
                .filter(o -> o.operation.equals(op))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public final int apply(final int x, final int y){
        return calculator.calculate(x, y);
    }
}
