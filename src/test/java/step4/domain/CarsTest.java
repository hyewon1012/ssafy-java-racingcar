package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차생성테스트(){
        //when
        String[] carNames = {"joy","elsa","anna"};
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        Cars cars = new Cars(carNames, racingCars);
        Cars expectedCars = new Cars(carNames, racingCars);

        //then
        assertThat(cars).isEqualTo(expectedCars);
    }

    @DisplayName("자동차 이름 공백 입력시 자동차 생성 테스트")
    @Test
    void 자동차이름공백입력시자동차생성테스트(){
        //when
        String[] carNames = {};
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cars(carNames, racingCars));

        //then
        assertThat(e.getMessage()).isEqualTo("자동차는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        String carName = "joy";
        RacingCar car = new RacingCar(carName);

        MoveStrategy moveStrategy = () -> true;
        car.move(moveStrategy);

        int actualPositionSize = car.getPosition();

        Position position = new Position(1);
        int expectedPositionSize = position.getPosition();

        //then
        assertThat(actualPositionSize).isEqualTo(expectedPositionSize);
    }

    @DisplayName("자동차경주에 사용되는 자동차 인스턴스 비교 테스트")
    @Test
    void 자동차인스턴스비교테스트(){
        //when
        String[] carNames = {"joy","elsa","anna"};
        Cars cars = new Cars(carNames, new ArrayList<>());

        List<RacingCar> racingCars = cars.getRacingCars();
        List<RacingCar> otherRacingCars = cars.getRacingCars();

        assertThat(racingCars).isEqualTo(otherRacingCars);
    }
}