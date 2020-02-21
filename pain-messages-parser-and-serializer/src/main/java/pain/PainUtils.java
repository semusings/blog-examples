package pain;

import javax.xml.bind.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;

public class PainUtils {

    private static final ConcurrentHashMap<PainType, Marshaller> MARSHALLER = new ConcurrentHashMap<>(20);
    private static final ConcurrentHashMap<PainType, Unmarshaller> UNMARSHALLER = new ConcurrentHashMap<>(20);

    public static <T> String serialize(T document, Class<T> typeClass) {
        try (StringWriter writer = new StringWriter()) {
            PainType type = PainType.find(typeClass).orElseThrow(RuntimeException::new);
            MARSHALLER.putIfAbsent(type, JAXBContext.newInstance(typeClass).createMarshaller());
            JAXBElement jaxbElement = new JAXBElement<>(type.qName(), typeClass, document);
            MARSHALLER.get(type).marshal(jaxbElement, writer);
            return writer.toString();
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseValue(String message, Class<T> typeClass) {
        try {
            PainType painType = PainType.find(typeClass).orElseThrow(RuntimeException::new);
            final Class<?> typeClass1 = painType.painTypeClass();
            UNMARSHALLER.putIfAbsent(painType, JAXBContext.newInstance(typeClass1).createUnmarshaller());
            JAXBElement<T> result = (JAXBElement<T>) UNMARSHALLER.get(painType).unmarshal(new StringReader(message));
            return result.getValue();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
