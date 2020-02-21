package com.progressoft.kryptonite.catalog.contracts;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FileUploadException extends RuntimeException {

    private static final long serialVersionUID = 4720861459909129822L;

    private final List<ValidationError> errors = new ArrayList<>();

    public FileUploadException(ValidationError error) {
        errors.add(error);
    }

}
