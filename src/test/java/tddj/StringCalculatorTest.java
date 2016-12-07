package tddj;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void should_return_0_when_empty_string() {
        assertThat(new StringCalculator().add(""), is(0));
    }

    @Test
    public void should_return_1_when_string_1() {
        assertThat(new StringCalculator().add("1"), is(1));
    }

    @Test
    public void should_return_3_when_string_1_comma_2() {
        assertThat(new StringCalculator().add("1,2"), is(3));
    }
}