package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.Objects;

public final class RacingCar {

    private static final int INIT_TRACE_VALUE = 0;

    private Name name;
    private Position position;

    public RacingCar(String name){
        this.name = new Name(name);
        this.position = new Position(INIT_TRACE_VALUE);
    }

    public RacingCar(Name name){
        this.name = name;
        this.position = new Position(INIT_TRACE_VALUE);
    }

    public final void move(MoveStrategy moveStrategy){
        if(moveStrategy.move()){
            position.goForward();
        }
    }
    public Name getName() {
        return this.name;
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof RacingCar)){
            return false;
        }
        RacingCar racingCar = (RacingCar) obj;
        return (Objects.equals(name, racingCar.getName())) && (Objects.equals(position, racingCar.getPosition()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
