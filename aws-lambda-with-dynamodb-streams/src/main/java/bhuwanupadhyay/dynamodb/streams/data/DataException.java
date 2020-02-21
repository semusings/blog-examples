package bhuwanupadhyay.dynamodb.streams.data;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DataException extends RuntimeException {
    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public static <T> Supplier<T> throwDataExceptionSupplier(String message) {
        return () -> {
            throw new DataException(message);
        };
    }

}
