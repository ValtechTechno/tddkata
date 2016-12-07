package tddj;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String s) {
        if ("".equals(s)) return 0;
        if (!s.contains(",")) {
            return parseInt(s);
        }
        String[] values = s.split(",");
        return parseInt(values[0]) + parseInt(values[1]);
    }
}
