package step3.strategy;

import java.util.Random;

public class RandomMove implements MoveStrategy{

    @Override
    public boolean move() {
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            return true;
        }
        return false;
    }
}
