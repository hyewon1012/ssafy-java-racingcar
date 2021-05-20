package step2.strategy;

public class Subtraction implements Calculator {
    @Override
    public int calculate(int x, int y) {
        return Math.subtractExact(x,y);
    }
}
