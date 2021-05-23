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

        //2. 자동차 객체 생성
        MoveStrategy moveStrategy = new RandomMove();
        IntStream.range(START_IDX, numberOfCar)
                .forEach(c -> racingCars.add(new RacingCar(moveStrategy)));

        //3. 라운드 진행
        ResultView.printResultSentence();
        while(round-- > 0){
            racingCars.stream().forEach(c -> c.move());
            ResultView.printCarTrace(racingCars);
        }


    }
}
