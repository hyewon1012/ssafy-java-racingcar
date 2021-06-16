package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.RandomMove;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    String[] carNames = {"joy","elsa","anna"};
    Cars cars;

    @BeforeEach
    public void beforeEach(){
        cars = new Cars(carNames, new ArrayList<>());
        cars.move(new RandomMove());
    }

    @DisplayName("우승자 생성 테스트")
    @Test
    void 우승자생성테스트(){
        Winner winner = new Winner(cars);
        Winner other = new Winner(cars);

        assertThat(winner).isEqualTo(other);
    }

    @DisplayName("우승자 검증 테스트")
    @Test
    void 우승자검증테스트(){
        //when
        Winner winner = new Winner(cars);
        List<RacingCar> actualWinners = winner.pickWinners(cars);
        List<RacingCar> expectedWinners = winner.getWinner();

        //then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}