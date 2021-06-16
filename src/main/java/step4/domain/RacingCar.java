package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.Objects;

public final class RacingCar {

    private static final int INIT_TRACE_VALUE = 0;
    private static final int NAME_LENGTH_CONDITION = 5;

    private String name;
    private Position position;

    public RacingCar(String name){
        inputNameValidate(name);
        this.name = name;
        this.position = new Position(INIT_TRACE_VALUE);
    }

    private void inputNameValidate(String name) {
        if(name.length() > NAME_LENGTH_CONDITION){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        if(Objects.isNull(name) || name.length() == 0){
            throw new IllegalArgumentException("자동차 이름은 한글자 이상이어야 합니다.");
        }
    }

    public final void move(MoveStrategy moveStrategy){
        if(moveStrategy.move()){
            position.goForward();
        }
    }

    public String getName(){
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
        return (name == racingCar.name) && (Objects.equals(position, racingCar.getPosition()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
