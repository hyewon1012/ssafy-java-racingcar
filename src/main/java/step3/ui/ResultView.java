package step3.ui;

import step3.domain.RacingCar;

import java.util.List;

public final class ResultView {
    private static final String RESULT_SENTENCE = "실행 결과";
    private static final String END_OF_LINE = "\n";

    public static void printResultSentence(){
        System.out.print(END_OF_LINE);
        System.out.println(RESULT_SENTENCE);
    }

    public static void printCarTrace(List<RacingCar> racingCarList){
        StringBuilder sb = new StringBuilder();
        racingCarList.stream().forEach(c -> System.out.println(c.getTrace()));
        System.out.print(END_OF_LINE);
    }

}
