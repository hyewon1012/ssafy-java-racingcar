package step3.domain;

import step3.strategy.MoveStrategy;
import step3.strategy.RandomMove;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class RacingCarGame {
    private List<RacingCar> racingCars;
    private final int START_IDX = 0;

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();
        game.playGame();
    }
    public void playGame(){
        //1. 사용자 입력 처리
        InputView.provideInput();
        int numberOfCar = InputView.numberOfCar;
        int round = InputView.round;

        //2. 사용자 입력에 따른 자동차 객체 생성
        MoveStrategy moveStrategy = new RandomMove();
        generateRacingCars(numberOfCar, moveStrategy);
        this.racingCars = getRacingCars();

        //3. 실행 결과 문구 출력
        ResultView.printResultSentence();

        //4. 라운드 진행 후 결과 출력
        while(round-- > 0){
            playRound();
            ResultView.printCarTrace(racingCars);
        }
    }

    private void generateRacingCars(final int numberOfCar, MoveStrategy moveStrategy){
        racingCars = new ArrayList<RacingCar>();
        IntStream.range(START_IDX, numberOfCar)
                .forEach(c -> this.racingCars.add(new RacingCar(moveStrategy)));
    }

    private void playRound(){
        racingCars.stream().forEach(c -> c.move());
    }

    public List<RacingCar> getRacingCars(){
        return this.racingCars;
    }
}
