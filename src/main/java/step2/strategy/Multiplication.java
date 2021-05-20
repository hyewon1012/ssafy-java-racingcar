package step2.strategy;

public class Multiplication implements Calculator {
    @Override
    public int calculate(int x, int y) {
        return Math.multiplyExact(x,y);
    }
}
