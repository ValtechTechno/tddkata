package tddj;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String s) {
        return "".equals(s) ? 0 : parseInt(s);
    }
}
