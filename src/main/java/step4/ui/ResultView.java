package step4.ui;

import step4.domain.Cars;
import step4.domain.Position;
import step4.domain.RacingCar;
import step4.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;
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

    public static void printCarInfo(Cars cars){
        List<RacingCar> printedCars = cars.getRacingCars();
        printedCars.stream()
                .forEach(car -> {
                    printCarName(car);
                    printCarPosition(car);
                    System.out.print(END_OF_LINE);
                });
        System.out.print(END_OF_LINE);
    }

    public static void printCarName(RacingCar racingCar){
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName()).append(" : ");
        System.out.print(sb.toString());
    }

    private static void printCarPosition(RacingCar car) {
        System.out.print(makeTraceMark(car.getPosition()));
    }

    public static String makeTraceMark(int position){
        StringBuilder sb = new StringBuilder();
        IntStream.range(START_INDEX, position)
                .forEach( x -> sb.append(MARK));
        return sb.toString();
    }

    public static void printWinner(Winner winner){
        StringBuilder sb = new StringBuilder();

        List<RacingCar> winners = winner.getWinner();
        String winnerNames = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
        sb.append(winnerNames).append("가 최종 우승했습니다.");

        System.out.print(sb.toString());
        System.out.print(END_OF_LINE);
    }

}
