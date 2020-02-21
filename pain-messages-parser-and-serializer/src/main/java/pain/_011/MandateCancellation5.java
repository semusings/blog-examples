
package pain._011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MandateCancellation5 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateCancellation5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlMsgInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}OriginalMessageInformation1" minOccurs="0"/>
 *         &lt;element name="CxlRsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PaymentCancellationReason1"/>
 *         &lt;element name="OrgnlMndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}OriginalMandate4Choice"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateCancellation5", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "orgnlMsgInf",
    "cxlRsn",
    "orgnlMndt",
    "splmtryData"
})
public class MandateCancellation5 {

    @XmlElement(name = "OrgnlMsgInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected OriginalMessageInformation1 orgnlMsgInf;
    @XmlElement(name = "CxlRsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected PaymentCancellationReason1 cxlRsn;
    @XmlElement(name = "OrgnlMndt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected OriginalMandate4Choice orgnlMndt;
    @XmlElement(name = "SplmtryData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected List<SupplementaryData1> splmtryData;

    /**
     * Gets the value of the orgnlMsgInf property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalMessageInformation1 }
     *     
     */
    public OriginalMessageInformation1 getOrgnlMsgInf() {
        return orgnlMsgInf;
    }

    /**
     * Sets the value of the orgnlMsgInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalMessageInformation1 }
     *     
     */
    public void setOrgnlMsgInf(OriginalMessageInformation1 value) {
        this.orgnlMsgInf = value;
    }

    /**
     * Gets the value of the cxlRsn property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentCancellationReason1 }
     *     
     */
    public PaymentCancellationReason1 getCxlRsn() {
        return cxlRsn;
    }

    /**
     * Sets the value of the cxlRsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCancellationReason1 }
     *     
     */
    public void setCxlRsn(PaymentCancellationReason1 value) {
        this.cxlRsn = value;
    }

    /**
     * Gets the value of the orgnlMndt property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalMandate4Choice }
     *     
     */
    public OriginalMandate4Choice getOrgnlMndt() {
        return orgnlMndt;
    }

    /**
     * Sets the value of the orgnlMndt property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalMandate4Choice }
     *     
     */
    public void setOrgnlMndt(OriginalMandate4Choice value) {
        this.orgnlMndt = value;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
