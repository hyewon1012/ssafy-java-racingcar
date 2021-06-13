package step3.domain;

import java.util.Objects;

public class Round {
    private static final int MIN_NUMBER_OF_ROUND = 0;
    private int round;

    public Round(final int round){
        validateRound(round);
        this.round = round;
    }

    private void validateRound(final int round) {
        if(round <= MIN_NUMBER_OF_ROUND){
            throw new IllegalArgumentException("라운드의 횟수는 1이상이어야 합니다.");
        }
    }

    public boolean hasNextRound(){
        if(this.round > MIN_NUMBER_OF_ROUND){
            return true;
        }else{
            return false;
        }
    }

    public void nextRound(){
        this.round--;
    }

    public int getRound(){
        return this.round;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Round)){
            return false;
        }
        Round round = (Round) obj;
        return Objects.equals(this.round, round.getRound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.round);
    }
}
