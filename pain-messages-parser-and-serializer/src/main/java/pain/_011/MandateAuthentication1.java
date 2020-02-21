
package pain._011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MandateAuthentication1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateAuthentication1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgAuthntcnCd" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Max16Text" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ISODate" minOccurs="0"/>
 *         &lt;element name="Chanl" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}AuthenticationChannel1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateAuthentication1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "msgAuthntcnCd",
    "dt",
    "chanl"
})
public class MandateAuthentication1 {

    @XmlElement(name = "MsgAuthntcnCd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected String msgAuthntcnCd;
    @XmlElement(name = "Dt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "Chanl", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected AuthenticationChannel1Choice chanl;

    /**
     * Gets the value of the msgAuthntcnCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgAuthntcnCd() {
        return msgAuthntcnCd;
    }

    /**
     * Sets the value of the msgAuthntcnCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgAuthntcnCd(String value) {
        this.msgAuthntcnCd = value;
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * Gets the value of the chanl property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationChannel1Choice }
     *     
     */
    public AuthenticationChannel1Choice getChanl() {
        return chanl;
    }

    /**
     * Sets the value of the chanl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationChannel1Choice }
     *     
     */
    public void setChanl(AuthenticationChannel1Choice value) {
        this.chanl = value;
    }

}
