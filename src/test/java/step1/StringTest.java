package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("split 테스트")
    @Test
    void splitTest(){
        String input = "1,2";
        String[] result = input.split(",");
        String[] expected = {"1","2"};
        assertThat(expected).containsExactly(result);

    }

    @DisplayName("substring 테스트")
    @Test
    void subStringTest(){
        //given
        String input = "(1,2)";

        int begin = input.indexOf("(");
        int end = input.indexOf(")");

        StringUtils stringUtils = StringUtils.getInstance();

        //when
        String result = stringUtils.subString(input, begin+1, end);

        StringJoiner expectedString = new StringJoiner(",");
        expectedString.add("1");
        expectedString.add("2");

        //then
        assertThat(expectedString.toString()).isEqualTo(result);
    }

    @DisplayName("특정 위치의 문자 찾기 예외처리 테스트")
    @Test
    void charAtExceptionTest(){
        //given
        String input = "abc";
        int findIndex = 3;
        StringUtils stringUtils = StringUtils.getInstance();

        //when and then
        assertThatThrownBy(() -> {input.charAt(findIndex);})
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
