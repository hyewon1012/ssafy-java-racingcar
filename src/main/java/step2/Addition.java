package step2;

public class Addition implements Operator{
    @Override
    public int operate(int x, int y) {
        return x+y;
    }
}
