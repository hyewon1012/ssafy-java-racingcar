package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.RacingCar;
import step3.domain.RacingCarGame;
import step3.strategy.MoveStrategy;
import step3.strategy.RandomMove;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차이동테스트(){
        //when
        MoveStrategy moveStrategy = new RandomMove();
        RacingCar car = new RacingCar(moveStrategy);

        int moveSize = car.getTrace();
        int expectedMoveSize = car.move();

        //then
        assertThat(moveSize).isEqualTo(expectedMoveSize);
    }

}
