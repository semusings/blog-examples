
package pain._011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OriginalMandate4Choice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OriginalMandate4Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="OrgnlMndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Max35Text"/>
 *         &lt;element name="OrgnlMndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Mandate9"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalMandate4Choice", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "orgnlMndtId",
    "orgnlMndt"
})
public class OriginalMandate4Choice {

    @XmlElement(name = "OrgnlMndtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected String orgnlMndtId;
    @XmlElement(name = "OrgnlMndt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected Mandate9 orgnlMndt;

    /**
     * Gets the value of the orgnlMndtId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMndtId() {
        return orgnlMndtId;
    }

    /**
     * Sets the value of the orgnlMndtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMndtId(String value) {
        this.orgnlMndtId = value;
    }

    /**
     * Gets the value of the orgnlMndt property.
     * 
     * @return
     *     possible object is
     *     {@link Mandate9 }
     *     
     */
    public Mandate9 getOrgnlMndt() {
        return orgnlMndt;
    }

    /**
     * Sets the value of the orgnlMndt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mandate9 }
     *     
     */
    public void setOrgnlMndt(Mandate9 value) {
        this.orgnlMndt = value;
    }

}
