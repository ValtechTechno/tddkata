package tddj;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void should_return_0_when_empty_string() {
        assertThat(calculator.add(""), is(0));
    }

    @Test
    public void should_return_1_when_string_1() {
        assertThat(calculator.add("1"), is(1));
    }

    @Test
    public void should_return_3_when_string_1_comma_2() {
        assertThat(calculator.add("1,2"), is(3));
    }

    @Test
    public void should_return_the_3_when_string_1_comma_1_comma_1() {
        assertThat(calculator.add("1,1,1"), is(3));
    }
}