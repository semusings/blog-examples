package io.github.bhuwanupadhyay.gridfs;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.progressoft.kryptonite.catalog.contracts.FileUploadMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
class FileRepository {

    private static final String FILE_ID = "fileId";
    private final GridFsOperations fs;

    @SneakyThrows
    void store(FileUploadMessage message) {
        fs.store(
                byteArray(message.getBytes()),
                message.getFileName(),
                message.getFileType(),
                entity(message)
        );
    }

    private ByteArrayInputStream byteArray(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    private FileMetaEntity entity(FileUploadMessage message) {
        FileMetaEntity entity = new FileMetaEntity();
        entity.setImageId(message.getImageId());
        return entity;
    }

    Optional<GridFSFile> findOne(String id) {
        Criteria criteria = GridFsCriteria.whereMetaData(FILE_ID).is(id);
        return Optional.ofNullable(fs.findOne(Query.query(criteria)));
    }
}
