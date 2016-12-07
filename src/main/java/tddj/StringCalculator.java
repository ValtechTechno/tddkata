package tddj;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String s) {
        if ("".equals(s)) return 0;
        String[] values = s.split(",");
        int sum = 0;
        for (String value : values) {
            sum = sum + parseInt(value);
        }
        return sum;
    }
}
