package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.domain.RacingCar;
import step3.domain.Round;
import step3.strategy.RandomMove;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차생성테스트(){
        //when
        int numberOfCar = 3;
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        Cars cars = new Cars(numberOfCar, racingCars);
        Cars expectedCars = new Cars(numberOfCar, racingCars);

        //then
        assertThat(cars).isEqualTo(expectedCars);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        RacingCar car = new RacingCar();

        int stop = 0;
        int go = 1;

        car.move(new RandomMove());

        //then
        int moveSize = car.getTrace();

        if(moveSize > 0){
            assertThat(moveSize).isEqualTo(go);
        }else{
            assertThat(moveSize).isEqualTo(stop);
        }

    }

    @DisplayName("라운드 생성 테스트")
    @Test
    void 라운드생성테스트(){
        //when
        int numberOfRound = 3;
        Round round = new Round(numberOfRound);
        Round expectedRound = new Round(numberOfRound);

        //then
        assertThat(round).isEqualTo(expectedRound);
    }

}
