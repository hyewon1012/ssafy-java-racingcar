package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차생성테스트(){
        //when
        String[] carNames = {"joy","elsa","anna"};
        Names names = new Names(carNames);

        Cars cars = new Cars(names);
        Cars expectedCars = new Cars(names);

        //then
        assertThat(cars).isEqualTo(expectedCars);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        String carName = "joy";
        RacingCar car = new RacingCar(carName);

        MoveStrategy moveStrategy = () -> true;
        car.move(moveStrategy);

        Position actualPosition = car.getPosition();
        Position expectedPosition = new Position(1);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("자동차경주에 사용되는 자동차 인스턴스 비교 테스트")
    @Test
    void 자동차인스턴스비교테스트(){
        //when
        String[] carNames = {"joy","elsa","anna"};
        Cars cars = new Cars(new Names(carNames));

        List<RacingCar> racingCars = cars.getRacingCars();
        List<RacingCar> otherRacingCars = cars.getRacingCars();

        assertThat(racingCars).isEqualTo(otherRacingCars);
    }
}