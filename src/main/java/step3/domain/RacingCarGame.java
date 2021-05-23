package step3.domain;

import step3.strategy.MoveStrategy;
import step3.strategy.RandomMove;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class RacingCarGame {
    private final List<RacingCar> racingCars = new ArrayList<RacingCar>();
    private final int START_IDX = 0;
    
    public void playGame(){
        //1. 사용자 입력 처리
        InputView.provideInput();
        int numberOfCar = InputView.numberOfCar;
        int round = InputView.round;

        //2. 사용자 입력에 따른 자동차 객체 생성
        generateRacingCars(numberOfCar);

        //3. 실행 결과 문구 출력
        ResultView.printResultSentence();

        //4. 라운드 진행 후 결과 출력
        while(round-- > 0){
            playRound();
            ResultView.printCarTrace(racingCars);
        }
    }

    private void generateRacingCars(int numberOfCar){
        MoveStrategy moveStrategy = new RandomMove();
        IntStream.range(START_IDX, numberOfCar)
                .forEach(c -> this.racingCars.add(new RacingCar(moveStrategy)));
    }

    private void playRound(){
        racingCars.stream().forEach(c -> c.move());
    }
}
