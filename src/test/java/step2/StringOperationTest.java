package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringOperationTest {
    StringOperation stringOperation;

    @BeforeEach
    public void beforeEach(){
        stringOperation = StringOperation.getInstance();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"2 + 3:5", "6 + 9:15", "0 + 1:1"}, delimiter = ':')
    void 덧셈(String input, Integer expected){
        //when
        int addResult = stringOperation.calculate(input);

        //then
        assertThat(addResult).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 - 3:2", "6 - 9:-3", "1 - 1:0"}, delimiter = ':')
    void 뺄셈(String input, Integer expected){
        //when
        int subtractResult = stringOperation.calculate(input);

        //then
        assertThat(subtractResult).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 * 3:15", "6 * 9:54", "1 * 0:0"}, delimiter = ':')
    void 곱셈(String input, Integer expected){
        //when
        int multiplyResult = stringOperation.calculate(input);

        //then
        assertThat(multiplyResult).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"5 / 3:1", "12 / 6:2", "25 / 5:5"}, delimiter = ':')
    void 나눗셈(String input, Integer expected){
        //when
        int divideResult = stringOperation.calculate(input);

        //then
        assertThat(divideResult).isEqualTo(expected);
    }

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우")
    @ParameterizedTest(name = "{0} 는 입력값이 null 이거나 공백 문자열입니다.")
    @NullAndEmptySource
    void 공백문자열사칙연산(String input){
        //when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringOperation.calculate(input);
        });
    }

    @DisplayName("잘못된 사칙연산 기호 사용")
    @ParameterizedTest(name = "{0} 는 잘못된 사칙연산 기호가 포함되있습니다.")
    @ValueSource(strings = {"3 == 5", "1 && 7", "4 ?? 4"})
    void 잘못된연산기호사용(String input){
        //when and then
        assertThatThrownBy(() -> stringOperation.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 사칙연산 수행")
    @ParameterizedTest(name = "{0} 결과는 {1} 입니다.")
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 7 / 2 - 1:3", "4 * 4 * 4 / 4:16"}, delimiter = ':')
    void 사칙연산(String input, Integer expected){
        //when
        int result = stringOperation.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
