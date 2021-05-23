package step3.domain;

import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class RacingCarGame {
    private final List<RacingCar> racingCarList = new ArrayList<>();
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

        //2. 자동차 객체 생성
        IntStream.range(START_IDX, numberOfCar)
                .forEach(c -> racingCarList.add(new RacingCar()));

        //3. 라운드 진행
        ResultView.printResultSentence();
        while(round-- > 0){
            racingCarList.stream().forEach(c -> c.move());
            ResultView.printCarTrace(racingCarList);
        }


    }
}
