package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 크기 확인 테스트")
    @Test
    public void sizeCheck(){
        int setSize = numbers.size();
        assertThat(numbers).hasSize(setSize);
    }

    @DisplayName("Set Value 확인 테스트")
    @ParameterizedTest(name="Set에 {0}는 존재합니다.")
    @ValueSource(ints = {1,2,3})
    public void contains(int value){
        assertThat(numbers.contains(value)).isTrue();

    }

    @DisplayName("Set에 존재하지않는 value가 있는지 테스트")
    @ParameterizedTest(name="Set에 {index} 의 존재여부 :''{1}''")
    @CsvSource(value = {"3:True","2:True","1:True","4:False","5:False"}, delimiter = ':')
    public void containsAllCheck(int input, boolean expected){
        boolean isContain = numbers.contains(input);
        assertThat(expected).isEqualTo(isContain);

    }
}
