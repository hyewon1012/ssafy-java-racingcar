package step3.domain;

import step3.strategy.MoveStrategy;

public final class RacingCar {

    private static final int INIT_TRACE_VALUE = 0;
    private static final int MOVING_CONDITION = 4;
    private MoveStrategy moveStrategy;
    private int trace;

    public RacingCar(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.trace = INIT_TRACE_VALUE;
    }

    public final int move(){
        if(moveStrategy.move() >= MOVING_CONDITION){
            this.trace++;
        }
        return this.trace;
    }

    public int getTrace(){
        return this.trace;
    }
}
