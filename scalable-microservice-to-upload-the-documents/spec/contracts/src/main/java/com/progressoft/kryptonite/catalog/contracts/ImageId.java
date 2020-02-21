package com.progressoft.kryptonite.catalog.contracts;


import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageId {

    private static final String SEPARATOR = "-";

    @NonNull
    private final String id;

    public static ImageId create(String prefix) {
        return new ImageId(prefix + SEPARATOR + UUID.randomUUID().toString());
    }


}
