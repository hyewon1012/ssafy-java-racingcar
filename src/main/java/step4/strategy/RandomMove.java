package step4.strategy;

import java.util.Random;

public class RandomMove implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean move() {
        Random random = new Random();
        int moveSize = random.nextInt(10);
        if(moveSize >= MOVE_CONDITION){
            return true;
        }
        return false;
    }
}
