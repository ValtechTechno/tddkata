package tddj.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void should_return_0_when_empty_string() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    public void should_return_1_when_string_1() {
        assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    public void should_return_3_when_string_1_comma_2() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    public void should_return_3_when_string_1_NEWLINE_2() {
        assertThat(calculator.add("1\n2")).isEqualTo(3);
    }

    @Test
    public void should_return_the_sum_when_mixing_delimiters() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    public void should_return_the_number_value_when_there_is_one_empty() {
        assertThat(calculator.add("1,\n")).isEqualTo(1);
    }

    @Test
    public void should_return_the_3_when_string_1_comma_1_comma_1() {
        assertThat(calculator.add("1,1,1")).isEqualTo(3);
    }

    @Test
    public void should_use_the_delimiter_when_defined() {
        assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test(expected = NegativeNotAllowed.class)
    public void negative_not_allowed() {
        calculator.add("1,-1");
    }

    @Test()
    public void all_negative_are_mentioned() {
        try {
            calculator.add("-1,2,-1");
            fail("should not be here");
        } catch (NegativeNotAllowed negativeNotAllowed) {
            assertThat(negativeNotAllowed.getMessage()).isEqualTo("[-1, -1]");
        }

    }
}