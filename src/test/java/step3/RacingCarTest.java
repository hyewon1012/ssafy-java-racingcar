package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.CarsGenerator;
import step3.domain.RacingCar;
import step3.domain.Round;
import step3.strategy.MoveStrategy;
import step3.strategy.RandomMove;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차생성테스트(){
        //when
        int numberOfCar = 3;
        List<RacingCar> cars = new ArrayList<>(numberOfCar);
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new RacingCar(new RandomMove()));
        }
        CarsGenerator carsGenerator = new CarsGenerator(numberOfCar, cars);

        List<RacingCar> generateCars = carsGenerator.getRacingCars();

        //then
        assertThat(generateCars.size()).isEqualTo(numberOfCar);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        MoveStrategy moveStrategy = new RandomMove();
        RacingCar car = new RacingCar(moveStrategy);

        int stop = 0;
        int go = 1;

        car.move();

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
        int result = round.getRound();

        //then
        assertThat(result).isEqualTo(numberOfRound);
    }

}
