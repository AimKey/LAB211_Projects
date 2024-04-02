package Common;

import java.util.function.Predicate;

public class Validate {

    public <T> void validate(String errorMsg, T[] values, Predicate<T> predicate) throws Exception {
        for (T value : values) {
            if (!predicate.test(value))
                throw new Exception(errorMsg);
        }
    }
}
