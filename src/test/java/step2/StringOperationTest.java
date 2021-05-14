package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringOperationTest {
    @DisplayName("덧셈 테스트")
    @Test
    void 덧셈(){
        //given
        String input = "2 + 3";
        //when
        List<String> operand = Arrays.asList(input.split(" "));
        //then
        int addResult = StringOperation.add(operand);
        assertThat(addResult).isEqualTo(5);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void 뺄셈(){
        //given
        String input = "5 - 3";
        //when
        List<String> operand = Arrays.asList(input.split(" "));
        //then
        int subtractResult = StringOperation.subtract(operand);
        assertThat(subtractResult).isEqualTo(2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void 곱셈(){
        //given
        String input = "5 * 3";
        //when
        List<String> operand = Arrays.asList(input.split(" "));
        //then
        int multiplyResult = StringOperation.multiply(operand);
        assertThat(multiplyResult).isEqualTo(15);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void 나눗셈(){
        //given
        String input = "5 / 3";
        //when
        List<String> operand = Arrays.asList(input.split(" "));
        //then
        int divideResult = StringOperation.divide(operand);
        assertThat(divideResult).isEqualTo(1);
    }
}
