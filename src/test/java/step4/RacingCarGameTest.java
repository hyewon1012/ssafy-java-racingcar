package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Cars;
import step4.domain.RacingCar;
import step4.domain.Winner;
import step4.strategy.RandomMove;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarGameTest {

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

    @DisplayName("5글자 이상의 이름을 가진 자동차 생성")
    @Test
    void 잘못된이름사용(){
        //when and then
        String carName = "christopher";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다");
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        String carName = "joy";
        RacingCar car = new RacingCar(carName);

        car.move(new RandomMove());
        int positionSize = car.getPosition();

        Position position = new Position(1);
        int expectedPositionSize = position.getPosition();

        //then
        assertThat(positionSize).isEqualTo(expectedPositionSize);
    }

    @DisplayName("우승자 검증 테스트")
    @Test
    void 우승자검증테스트(){
        //when
        String[] carNames = {"joy", "elsa", "anna"};
        Cars cars = new Cars(carNames, new ArrayList<>());
        cars.move(new RandomMove());

        List<RacingCar> racingCars = cars.getRacingCars();

        List<String> expectedWinners = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i=0; i < racingCars.size(); i++){
            int pos = racingCars.get(i).getPosition();
            if(max <= pos){
                expectedWinners.add(racingCars.get(i).getName());
            }
        }
        Winner winners = cars.findWinner();
        List<String> winnerNames = winners.getWinners();

        assertThat(winnerNames).isEqualTo(expectedWinners);
    }
}
