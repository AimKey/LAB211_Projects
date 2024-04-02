package Common;

import java.util.function.Predicate;

public class Validate {
    public <T> void validate(String errorMsg, T value, Predicate<T> predicate) throws Exception {
        if (!predicate.test(value))
            throw new Exception(errorMsg);
    }
}
