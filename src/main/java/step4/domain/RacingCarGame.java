package step4.domain;

import step4.strategy.RandomMove;
import step4.ui.InputView;
import step4.ui.ResultView;

import java.util.ArrayList;

public final class RacingCarGame {

    public void playGame(){
        //1. 사용자 입력 처리
        String[] inputNames = InputView.enterCarNames();
        Round round = new Round(InputView.enterRound());

        //2. 사용자 입력에 따른 자동차 객체 생성
        Cars cars = new Cars(inputNames, new ArrayList<>());

        //3. 실행 결과 문구 출력
        ResultView.printResultSentence();

        //4. 라운드 진행 후 결과 출력
        while(round.hasNextRound()){
            cars.move(new RandomMove());
            ResultView.printCarInfo(cars);
            round.nextRound();
        }

        //5. 우승자 출력
        Winner winner = new Winner(cars);
        ResultView.printWinner(winner);
    }

}
