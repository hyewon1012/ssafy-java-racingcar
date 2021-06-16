package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Cars;
import step4.domain.Position;
import step4.domain.RacingCar;
import step4.domain.Winner;
import step4.strategy.MoveStrategy;
import step4.strategy.RandomMove;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarGameTest {

    @DisplayName("Position 인스턴스 생성 및 비교 테스트")
    @Test
    void Position생성및비교테스트(){
        //when
        int positionSize = 1;
        Position actualPosition = new Position(positionSize);
        Position expectedPosition = new Position(positionSize);

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("우승자 생성 및 검증 테스트")
    @Test
    void 우승자생성및검증테스트(){
        //when
        String[] carNames = {"joy", "elsa", "anna"};
        Cars cars = new Cars(carNames, new ArrayList<>());
        
        cars.move(new RandomMove());

        Winner winner = new Winner(cars);
        List<RacingCar> actualWinners = winner.pickWinners(cars);
        List<RacingCar> expectedWinners = winner.getWinner();

        //then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}
