package io.github.bhuwanupadhyay.gridfs;


import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RequestMapping(ApiConstants.API_VERSION)
@RestController
@Slf4j
@RequiredArgsConstructor
public class FileEndpoint {

    private final FileRepository repository;
    private final GridFSBucket bucket;

    @GetMapping(value = "/files/{fileId}")
    public ResponseEntity<byte[]> findById(@PathVariable String fileId) {
        return repository.findOne(fileId)
                .map(this::response)
                .orElse(ResponseEntity.badRequest().build());
    }

    @SneakyThrows
    private byte[] bytes(GridFSFile file, GridFSDownloadStream downloadStream) {
        GridFsResource resource = new GridFsResource(file, downloadStream);
        InputStream stream = resource.getInputStream();
        byte[] bytes = new byte[stream.available()];
        IOUtils.readFully(stream, bytes);
        return bytes;
    }

    private ResponseEntity<byte[]> response(GridFSFile file) {
        GridFSDownloadStream downloadStream = bucket.openDownloadStream(file.getObjectId());
        return new ResponseEntity<>(bytes(file, downloadStream), multiValue(file), HttpStatus.OK);
    }

    private MultiValueMap<String, String> multiValue(GridFSFile file) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set("Content-Disposition", "attachment; filename=" + file.getFilename());
        return map;
    }

}
