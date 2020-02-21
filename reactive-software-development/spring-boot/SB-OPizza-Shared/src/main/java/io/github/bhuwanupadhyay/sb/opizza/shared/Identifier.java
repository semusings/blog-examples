package io.github.bhuwanupadhyay.sb.opizza.shared;

import java.util.UUID;

public interface Identifier<T> {

    static String newId() {
        return UUID.randomUUID().toString();
    }

    T value();

}
