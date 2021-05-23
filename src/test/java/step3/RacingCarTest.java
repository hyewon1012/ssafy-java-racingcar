package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
//    @DisplayName("사용자 입력 테스트")
//    @Test
//    void 사용자입력(){
//        RacingCar car = new RacingCar();
//        final String input = "3 5";
//
//        car.provideInput(input);
//        String output = car.getOutput();
//
//        assertThat(input).isEqualTo(output);
//    }

    @DisplayName("랜덤값이 4이상일때 자동차가 움직이는지 테스트")
    @Test
    void 자동차이동(){
        RacingCar car = new RacingCar();
        Random random = new Random();

        int step = random.nextInt(10);
        int moveSize = car.move(step);

        assertThat(step).isEqualTo(moveSize);
    }

//    @DisplayName("자동차 경주 화면 출력 테스트")
//    @Test
//    void 자동차이동출력(){
//        RacingCar car = new RacingCar();
//        final String input = "3 5";
//
//        car.provideInput(input);
//
//        Random random = new Random();
//
//        int step = random.nextInt(10);
//        int moveSize = car.move(step);
//
//        car.movePrint();
//        assertThat()
//
//    }
}
