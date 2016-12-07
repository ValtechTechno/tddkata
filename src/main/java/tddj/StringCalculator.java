package tddj;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String s) {
        if ("".equals(s)) return 0;

        Parser parser = new Parser(s);
        String[] values = parser.getNumbers();
        int sum = 0;
        for (String value : values) {
            try {
                sum = sum + parseInt(value);
            } catch (NumberFormatException nfe) {
                throw new NegativeNotAllowed();
            }
        }
        return sum;
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