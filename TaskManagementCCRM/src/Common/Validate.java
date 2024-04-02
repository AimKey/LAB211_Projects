package Common;

import java.util.function.Predicate;

public class Validate {
    // IMPORTANT: the T[] values means array of not primitive objects (Like int[],
    // double[]). Use Double[] or Int[] instead
    public <T> void validate(String errorMsg, T[] values, Predicate<T> predicate) throws Exception {
        for (T value : values) {
            if (!predicate.test(value))
                throw new Exception(errorMsg);
        }
    }
}
