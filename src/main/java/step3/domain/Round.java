package step3.domain;

public class Round {
    private static final int MIN_NUMBER_OF_ROUND = 0;
    private int round;

    public Round(final int round){
        validateRound(round);
        this.round = round;
    }

    private void validateRound(final int round) {
        if(round <= MIN_NUMBER_OF_ROUND){
            throw new IllegalArgumentException();
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
}
