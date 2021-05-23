package step3.ui;

import java.util.Scanner;

public final class InputView {
    private static final String NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND = "시도할 회수는 몇 회 인가요?";

    public static int numberOfCar;
    public static int round;

    private InputView() {
    }

    public static void provideInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(NUMBER_OF_CARS);
        numberOfCar = scanner.nextInt();

        System.out.println(ROUND);
        round = scanner.nextInt();

    }
}
