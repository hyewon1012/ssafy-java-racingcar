package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @DisplayName("이름 생성 테스트")
    @Test
    void 이름생성테스트(){
        //when
        String userName = "elsa";
        Name name = new Name(userName);
        Name expectedName = new Name(userName);

        //then
        assertThat(name).isEqualTo(expectedName);
    }

    @DisplayName("잘못된 이름을 가진 이름 인스턴스 생성 테스트")
    @Test
    void 잘못된이름인스턴스생성테스트(){
        //when
        String userName = "Christopher";

        //then
        //then
        assertThatThrownBy(() -> new Name(userName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일 이름 인스턴스 생성 시 비교 테스트")
    @Test
    void 동일이름생성(){
        //when
        String userName = "anna";
        Name name = new Name(userName);
        Name otherName = new Name(userName);

        //then
        assertThat(name.getName()).isEqualTo(otherName.getName());
    }
}