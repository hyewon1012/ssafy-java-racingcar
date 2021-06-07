package step3.domain;

public class Round {
    private static final int MIN_NUMBER_OF_ROUND = 0;
    private final int round;

    public Round(final int round){
        validateRound(round);
        this.round = round;
    }

    private void validateRound(final int round) {
        if(round <= MIN_NUMBER_OF_ROUND){
            throw new IllegalArgumentException();
        }
    }

    public int getRound(){
        return this.round;
    }
}
