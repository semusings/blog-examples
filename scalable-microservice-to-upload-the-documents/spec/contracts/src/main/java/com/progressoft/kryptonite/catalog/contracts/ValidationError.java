package com.progressoft.kryptonite.catalog.contracts;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidationError {

    private static final String ERROR = "error";

    @NonNull
    private final String violator;
    @NonNull
    private final String errorMessage;

    public static void raiseIf(boolean signal, String message) {
        if (signal) {
            throw new FileUploadException(new ValidationError(ERROR, message));
        }
    }

}
