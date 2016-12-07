package tddj;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String s) {
        if ("".equals(s)) return 0;
        String delimiter;
        if (s.startsWith("//")) {
            delimiter = s.substring(2,3);
            s = s.substring(4);
        } else {
            delimiter = "[,\n]";
        }
        String[] values = s.split(delimiter);
        int sum = 0;
        for (String value : values) {
            sum = sum + parseInt(value);
        }
        return sum;
    }
}
