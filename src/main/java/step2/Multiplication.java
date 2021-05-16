package step2;

public class Multiplication implements CalculateStrategy{
    @Override
    public int calculate(int x, int y) {
        return x*y;
    }
}
