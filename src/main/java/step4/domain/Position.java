package step4.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(final int position){
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if(position < 0){
            throw new IllegalArgumentException("자동차의 위치는 0이상입니다.");
        }
    }

    public void goForward(){
        this.position++;
    }

    public int getPosition(){
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Position)){
            return false;
        }
        Position position = (Position) obj;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
