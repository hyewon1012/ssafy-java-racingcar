package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    @DisplayName("자동차 이름 생성 테스트")
    @Test
    void 자동차이름생성테스트(){
        //when
        String[] userNames = {"elsa","anna","olaf"};
        Names names = new Names(userNames);

        List<Name> expectedNames = new ArrayList<>();
        for(int i=0; i < userNames.length; i++){
            expectedNames.add(new Name(userNames[i]));
        }

        //then
        assertThat(names).isEqualTo(expectedNames);
    }

    @DisplayName("5글자 이상의 이름을 가진 자동차 이름 생성 테스트")
    @Test
    void 다섯글자이상의이름을가진자동차이름생성테스트(){
        //when
        String[] userNames = {"olaf", "christopher", "elsa"};

        //then
        assertThatThrownBy(() -> new Names(userNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 공백 입력시 자동차 이름 생성 테스트")
    @Test
    void 자동차이름공백입력시자동차이름생성테스트(){
        //when
        String[] userNames = {};

        //then
        assertThatThrownBy(() -> new Names(userNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Names 인스턴스 비교 테스트")
    @Test
    void Names인스턴스비교테스트(){
        //when
        String[] userNames = {"joy","elsa","anna"};
        Names names = new Names(userNames);

        List<Name> actualNames = names.getNames();
        List<Name> expectedNames = names.getNames();

        //then
        assertThat(actualNames).isEqualTo(expectedNames);
    }


}