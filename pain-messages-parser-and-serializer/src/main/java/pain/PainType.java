package pain;

import javax.xml.namespace.QName;
import java.util.Optional;
import java.util.stream.Stream;

public enum PainType {
    PAIN010(pain._010.Document.class, "010"),
    PAIN011(pain._011.Document.class, "011");

    private final Class<?> painTypeClass;
    private final QName qName;

    PainType(Class<?> painTypeClass, String type) {
        this.painTypeClass = painTypeClass;
        this.qName = new QName("urn:iso:std:iso:20022:tech:xsd:pain." + type + ".001.05", "Document");
    }

    public static <T> Optional<PainType> find(Class<T> typeClass) {
        return Stream.of(PainType.values()).filter(painType -> painType.painTypeClass.equals(typeClass)).findFirst();
    }

    public Class<?> painTypeClass() {
        return painTypeClass;
    }

    public QName qName() {
        return qName;
    }
}
