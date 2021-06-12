package step3.domain;

import step3.strategy.RandomMove;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.ArrayList;

public final class RacingCarGame {

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();
        game.playGame();
    }
    public void playGame(){
        //1. 사용자 입력 처리
        InputView.provideInput();
        int numberOfCar = InputView.numberOfCar;
        Round round = new Round(InputView.round);

        //2. 사용자 입력에 따른 자동차 객체 생성
        Cars cars = new Cars(numberOfCar, new ArrayList<>());

        //3. 실행 결과 문구 출력
        ResultView.printResultSentence();

        //4. 라운드 진행 후 결과 출력
        int number_of_round = round.getRound();
        while(number_of_round-- > 0){
            cars.move(new RandomMove());
            ResultView.printCarTrace(cars);
        }
    }

}
