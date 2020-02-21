
package pain._011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MndtCxlReq" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateCancellationRequestV05"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "mndtCxlReq"
})
public class Document {

    @XmlElement(name = "MndtCxlReq", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected MandateCancellationRequestV05 mndtCxlReq;

    /**
     * Gets the value of the mndtCxlReq property.
     * 
     * @return
     *     possible object is
     *     {@link MandateCancellationRequestV05 }
     *     
     */
    public MandateCancellationRequestV05 getMndtCxlReq() {
        return mndtCxlReq;
    }

    /**
     * Sets the value of the mndtCxlReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateCancellationRequestV05 }
     *     
     */
    public void setMndtCxlReq(MandateCancellationRequestV05 value) {
        this.mndtCxlReq = value;
    }

}
