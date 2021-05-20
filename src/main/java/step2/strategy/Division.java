package step2.strategy;

public class Division implements Calculator {
    @Override
    public int calculate(int x, int y) {
        return Math.floorDiv(x,y);
    }
}
