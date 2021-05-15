package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringOperationTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"2 + 3:5", "6 + 9:15", "0 + 1:1"}, delimiter = ':')
    void 덧셈(String input, Integer expected){
        //when
        StringOperation stringOperation = StringOperation.getInstance();
        int addResult = stringOperation.calculate(input);
        //then
        assertThat(addResult).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 - 3:2", "6 - 9:-3", "1 - 1:0"}, delimiter = ':')
    void 뺄셈(String input, Integer expected){
        //when
        StringOperation stringOperation = StringOperation.getInstance();
        int subtractResult = stringOperation.calculate(input);
        //then
        assertThat(subtractResult).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 * 3:15", "6 * 9:54", "1 * 0:0"}, delimiter = ':')
    void 곱셈(String input, Integer expected){
        //when
        StringOperation stringOperation = StringOperation.getInstance();
        int multiplyResult = stringOperation.calculate(input);
        //then
        assertThat(multiplyResult).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 / 3:1", "12 / 6:2", "25 / 5:5"}, delimiter = ':')
    void 나눗셈(String input, Integer expected){
        //when
        StringOperation stringOperation = StringOperation.getInstance();
        int divideResult = stringOperation.calculate(input);
        //then
        assertThat(divideResult).isEqualTo(expected);
    }

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우")
    @NullAndEmptySource
    void 공백문자열사칙연산(String input){
        //given
        List<String> operand = Arrays.asList(input.split(" "));
        //when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringOperation.calculate(input);
        });
    }

    @DisplayName("잘못된 사칙연산 기호 사용")
    @Test
    @ValueSource(strings = {"3 ** 5", "1 -- 7", "4 ?? 4"})
    void 잘못된연산기호사용(String input){
        /*//when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> StringOperation.operate(operand));*/

        //when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringOperation.calculate(input);
        }).withMessageContaining("잘못된 연산 기호");
    }

    @DisplayName("올바른 사칙연산 수행")
    @Test
    void 사칙연산(){
        //given
        String input = "2 + 3 * 4 / 2";

        //when
        int result = StringOperation.calculate(input);

        //then
        assertThat(result).isEqualTo(10);

    }
}
