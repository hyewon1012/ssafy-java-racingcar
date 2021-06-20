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
    void 다섯글자이상의이름을가진자동차생성(){
        //when and then
        String carName = "christopher";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("공백 이름을 가진 자동차 생성")
    @Test
    void 공백이름을가진자동차생성(){
        //when and then
        String carName = "";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 한글자 이상이어야 합니다.");
    }

    @DisplayName("같은 이름을 가진 자동차가 동일한 자동차 객체인지 테스트")
    @Test
    void 동일이름을가진자동차인스턴스비교테스트(){
        //when
        String name = "elsa";
        RacingCar racingCar = new RacingCar(name);
        String expectedName = racingCar.getName().getName();

        //then
        assertThat(name).isEqualTo(expectedName);
    }
    
    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        String name = "anna";
        int moveSize = 3;
        RacingCar racingCar = new RacingCar(name);

        MoveStrategy moveStrategy = () -> true;
        for (int i=0; i < moveSize; i++){
            racingCar.move(moveStrategy);
        }

        Position actualPosition = racingCar.getPosition();
        Position expectedPosition = new Position(moveSize);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }


    @DisplayName("자동차 객체 생성시 초기 위치 검증 테스트")
    @Test
    void 자동차객체생성시초기위치검증테스트(){
        //when
        String name = "elsa";
        RacingCar racingCar = new RacingCar(name);

        Position actualPosition = racingCar.getPosition();
        Position expectedPosition = new Position(0);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}