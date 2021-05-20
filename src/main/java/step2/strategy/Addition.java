package step2.strategy;

public class Addition implements Calculator {
    @Override
    public int calculate(int x, int y) {
        return Math.addExact(x,y);
    }
}
