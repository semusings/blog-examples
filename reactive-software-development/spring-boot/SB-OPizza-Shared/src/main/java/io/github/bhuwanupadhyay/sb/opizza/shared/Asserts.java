package io.github.bhuwanupadhyay.sb.opizza.shared;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Asserts {

    private static final String VALUE_SHOULD_BE_NOT_NULL = "value should be not null";

    public static void isPositive(Integer integer, String message) {
        notNull(integer, VALUE_SHOULD_BE_NOT_NULL);
        raiseIfNot(integer > 0, message);
    }

    public static void notEmpty(String value, String message) {

        boolean isBlank = isBlank(value);

        raiseIf(isBlank, message);

    }

    public static void notNull(Object value, String message) {

        raiseIf(Objects.isNull(value), message);

    }

    public static void raiseIf(boolean signal, String message) {
        if (signal) {
            throw new OPizzaAssertError(message);
        }
    }

    public static void raiseIfNot(boolean signal, String message) {

        raiseIf(!signal, message);

    }

}
