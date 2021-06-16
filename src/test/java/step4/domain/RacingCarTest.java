package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    
    @DisplayName("같은 이름을 가진 자동차 생성 테스트")
    @Test
    void 같은이름을가진자동차생성테스트(){

        //when
        String name = "joy";
        RacingCar racingCar = new RacingCar(name);
        RacingCar otherRacingCar = new RacingCar(name);

        //then
        assertThat(racingCar).isEqualTo(otherRacingCar);
    }

    @DisplayName("5글자 이상의 이름을 가진 자동차 생성")
    @Test
    void 잘못된이름사용(){
        //when and then
        String carName = "christopher";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다");
    }

    @DisplayName("자동차 이름 검증 테스트")
    @Test
    void 자동차이름검증테스트(){

        //when
        String name = "elsa";
        RacingCar racingCar = new RacingCar(name);
        String expectedName = racingCar.getName();

        //then
        assertThat(name).isEqualTo(expectedName);
    }
    
    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        String name = "anna";
        RacingCar racingCar = new RacingCar(name);

        MoveStrategy moveStrategy = () -> true;
        racingCar.move(moveStrategy);

        Position actualPosition = racingCar.getPosition();
        Position expectedPosition = new Position(1);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}