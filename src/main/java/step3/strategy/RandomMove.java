package step3.strategy;

import java.util.Random;

public class RandomMove implements MoveStrategy{

    @Override
    public int move() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
