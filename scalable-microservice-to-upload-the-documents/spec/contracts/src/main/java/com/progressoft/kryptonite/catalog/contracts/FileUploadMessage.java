package com.progressoft.kryptonite.catalog.contracts;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

import static com.progressoft.kryptonite.catalog.contracts.ValidationError.raiseIf;
import static org.springframework.util.StringUtils.isEmpty;

@Getter
public class FileUploadMessage implements Message {

    private static final long serialVersionUID = 6904504020525583792L;

    private final byte[] bytes;
    private final String fileName;
    private final String imageId;
    private final String fileType;

    @SneakyThrows
    public FileUploadMessage(ImageId imageId, MultipartFile file) {

        raiseIf(isEmpty(imageId), "image.id.should.be.not.null");

        raiseIf(Objects.isNull(file), "multipart.file.should.be.not.null");

        raiseIf(isEmpty(file.getName()), "multipart.file.name.should.be.not.blank");

        raiseIf(file.isEmpty(), "multipart.file.should.be.not.invalid");

        this.bytes = file.getBytes();
        this.fileName = file.getName();
        this.imageId = imageId.getId();
        this.fileType = file.getContentType();
    }


}
