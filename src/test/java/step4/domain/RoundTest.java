package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    @DisplayName("라운드 생성 테스트")
    @Test
    void 라운드생성테스트(){
        //when
        int numberOfRound = 3;
        Round round = new Round(numberOfRound);
        Round expectedRound = new Round(numberOfRound);

        //then
        assertThat(round).isEqualTo(expectedRound);
    }

    @DisplayName("잘못된 입력을 가진 라운드 생성 테스트")
    @Test
    void 잘못된횟수로라운드생성테스트(){
        //when
        int numberOfRound = 0;

        //then
        assertThatThrownBy(() -> new Round(numberOfRound))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라운드를 모두 다 돌았을때 남은라운드 value 검증 테스트")
    @Test
    void 라운드를모두다돌았을때남은라운드검증(){
        //when
        int numberOfRound = 5;
        Round round = new Round(numberOfRound);

        for (int i = 0; i < numberOfRound; i++){
            round.nextRound();
        }
        //then
        assertFalse(round.hasNextRound());
    }

    @DisplayName("라운드 인스턴스 비교 테스트")
    @Test
    void 라운드인스턴스비교테스트(){
        //when
        int numberOfRound = 10;
        Round round = new Round(numberOfRound);
        Round other = new Round(numberOfRound);

        //then
        assertThat(round.getRound()).isEqualTo(other.getRound());
    }
}