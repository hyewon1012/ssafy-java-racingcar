package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

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
    
    @DisplayName("자동차 이동 성공 테스트")
    @Test
    void 자동차이동성공테스트(){
        //when
        String name = "anna";
        int moveSize = 3;
        RacingCar racingCar = new RacingCar(name);
        
        for (int i=0; i < moveSize; i++){
            racingCar.move(()-> true);
        }

        Position actualPosition = racingCar.getPosition();
        Position expectedPosition = new Position(moveSize);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("자동차 이동 실패 테스트")
    @Test
    void 자동차이동실패테스트(){
        //when
        String name = "anna";
        int moveSize = 0;
        RacingCar racingCar = new RacingCar(name);

        for (int i=0; i < moveSize; i++){
            racingCar.move(()-> false);
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