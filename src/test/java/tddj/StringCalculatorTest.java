package tddj;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void should_return_0_when_empty_string() {
        assertThat(new StringCalculator().add(""), is(0));
    }
}