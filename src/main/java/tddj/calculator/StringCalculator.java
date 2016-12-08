package tddj.calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String s) {
        if ("".equals(s)) return 0;

        Parser parser = new Parser(s);
        String[] values = parser.getNumbers();
        int sum = 0;
        List<String> errors = new ArrayList<String>();
        for (String value : values) {
            int i = parseInt(value);
            if (i < 0) {
                errors.add(value);
            }
            sum = sum + i;
        }
        if (errors.isEmpty())
            return sum;
        throw new NegativeNotAllowed(errors);
    }
}

class Parser {
    private final String input;
    private final String delimiter;

    public Parser(String input) {
        if (input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            this.input = input.substring(4);
        } else {
            delimiter = "[,\n]";
            this.input = input;
        }
    }

    public String[] getNumbers() {
        return input.split(delimiter);
    }
}