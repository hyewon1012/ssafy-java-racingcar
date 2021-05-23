package step3.domain;

import step3.strategy.MoveStrategy;

public final class RacingCar {
    private MoveStrategy moveStrategy;
    private int trace;

    public RacingCar(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    public final int move(){
        if(moveStrategy.move() >= 4){
            this.trace++;
        }
        return this.trace;
    }

    public int getTrace(){
        return this.trace;
    }
}
