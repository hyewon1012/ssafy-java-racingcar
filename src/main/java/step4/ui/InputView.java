package step4.ui;

import java.util.Scanner;

public final class InputView {
    private static final String NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String CAR_NAMES = "경주에 참여할 자동차 이름을 모두 입력해주세요";
    private static final String ROUND = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int enterNumberOfCar(){
        System.out.println(NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public static String[] enterCarNames(){
        System.out.println(CAR_NAMES);
        return scanner.nextLine().split(",");
    }

    public static int enterRound(){
        System.out.println(ROUND);
        return scanner.nextInt();
    }

}
