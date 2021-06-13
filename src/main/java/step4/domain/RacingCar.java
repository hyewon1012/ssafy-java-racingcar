package step4.domain;

import step4.strategy.MoveStrategy;

public final class RacingCar {

    private static final int INIT_TRACE_VALUE = 0;

    private int trace;

    public RacingCar(){
        this.trace = INIT_TRACE_VALUE;
    }

    public final void move(MoveStrategy moveStrategy){
        if(moveStrategy.move() > INIT_TRACE_VALUE){
            this.trace++;
        }
    }

    public int getTrace(){
        return this.trace;
    }

}
