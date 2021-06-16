package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @DisplayName("같은 위치를 가진 Position 생성 테스트")
    @Test
    void 같은위치를가진Position생성테스트(){
        //when
        int positionSize = 3;
        Position position = new Position(positionSize);
        Position other = new Position(positionSize);

        //then
        assertThat(position).isEqualTo(other);
    }

    @DisplayName("잘못된 위치를 가진 Position 생성 테스트")
    @Test
    void 잘못된위치를가진Position생성테스트(){
        //when
        int positionSize = -1;

        //then
        assertThatThrownBy(() -> new Position(positionSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 위치를 가진 Position 인스턴스 비교 테스트")
    @Test
    void 같은위치를가진Position인스턴스비교테스트(){
        //when
        int positionSize = 5;
        Position position = new Position(positionSize);
        Position other = new Position(positionSize);

        //then
        assertThat(position.getPosition()).isEqualTo(other.getPosition());
    }

    @DisplayName("위치 증가 테스트")
    @Test
    void 위치증가테스트(){
        //when
        int positionSize = 5;
        Position position = new Position(positionSize);

        position.goForward();

        int actualPosition = position.getPosition();
        int expectedPosition = ++positionSize;

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}