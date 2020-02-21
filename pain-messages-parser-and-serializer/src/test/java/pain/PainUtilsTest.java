package pain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pain._011.Document;

import java.io.IOException;
import java.net.URL;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.Optional.ofNullable;

class PainUtilsTest {

    @Test
    void can_serialize_pain011_when_given_valid_message() throws IOException {
        String originalMessage = readString("valid.pain.011.001.05.xml");
        Assertions.assertDoesNotThrow(() -> {
            pain._011.Document document = PainUtils.parseValue(originalMessage, pain._011.Document.class);
            PainUtils.serialize(document, Document.class);
        });
    }

    @SuppressWarnings("SameParameterValue")
    private String readString(String file) throws IOException {
        URL resource = getClass().getClassLoader().getResource(file);
        return String.join("", readAllLines(get(ofNullable(resource).orElseThrow(RuntimeException::new).getPath())));
    }
}