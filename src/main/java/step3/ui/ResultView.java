package step3.ui;

import step3.domain.Cars;
import step3.domain.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public final class ResultView {
    private static final String RESULT_SENTENCE = "실행 결과";
    private static final String END_OF_LINE = "\n";
    private static final String MARK = "-";
    private static final int START_INDEX = 0;

    public static void printResultSentence(){
        System.out.print(END_OF_LINE);
        System.out.println(RESULT_SENTENCE);
    }

    public static void printCarTrace(Cars cars){
        List<RacingCar> printedCars = cars.getRacingCars();
        printedCars.stream().forEach(c -> System.out.println(makeTraceMark(c.getTrace())));
        System.out.print(END_OF_LINE);
    }

    public static String makeTraceMark(int traceSize){
        StringBuilder sb = new StringBuilder();
        IntStream.range(START_INDEX, traceSize)
                .forEach( x -> sb.append(MARK));
        return sb.toString();
    }

}
