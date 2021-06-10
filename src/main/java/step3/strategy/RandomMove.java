package step3.strategy;

import java.util.Random;

public class RandomMove implements MoveStrategy{
    private static final int MOVE_CONDITION = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    @Override
    public int move() {
        Random random = new Random();
        int moveSize = random.nextInt(10);
        if(moveSize >= MOVE_CONDITION){
            return GO;
        }
        return STOP;
    }
}
