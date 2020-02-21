
package pain._011;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Frequency10Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Frequency10Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEVR"/>
 *     &lt;enumeration value="YEAR"/>
 *     &lt;enumeration value="RATE"/>
 *     &lt;enumeration value="MIAN"/>
 *     &lt;enumeration value="QURT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Frequency10Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
@XmlEnum
public enum Frequency10Code {

    NEVR,
    YEAR,
    RATE,
    MIAN,
    QURT;

    public String value() {
        return name();
    }

    public static Frequency10Code fromValue(String v) {
        return valueOf(v);
    }

}
