package tddj;

import java.util.List;

public class NegativeNotAllowed extends RuntimeException {
    public NegativeNotAllowed(List<String> errors) {
        super(errors.toString());
    }
}
