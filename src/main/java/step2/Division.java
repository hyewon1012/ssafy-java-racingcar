package step2;

public class Division implements CalculateStrategy{
    @Override
    public int calculate(int x, int y) {
        return x/y;
    }
}
