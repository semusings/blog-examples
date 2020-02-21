
package pain._011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MandateOccurrences4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateOccurrences4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SeqTp" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}SequenceType2Code"/>
 *         &lt;element name="Frqcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="Drtn" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}DatePeriodDetails1" minOccurs="0"/>
 *         &lt;element name="FrstColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ISODate" minOccurs="0"/>
 *         &lt;element name="FnlColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ISODate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateOccurrences4", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "seqTp",
    "frqcy",
    "drtn",
    "frstColltnDt",
    "fnlColltnDt"
})
public class MandateOccurrences4 {

    @XmlElement(name = "SeqTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    @XmlSchemaType(name = "string")
    protected SequenceType2Code seqTp;
    @XmlElement(name = "Frqcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected Frequency36Choice frqcy;
    @XmlElement(name = "Drtn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected DatePeriodDetails1 drtn;
    @XmlElement(name = "FrstColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frstColltnDt;
    @XmlElement(name = "FnlColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fnlColltnDt;

    /**
     * Gets the value of the seqTp property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceType2Code }
     *     
     */
    public SequenceType2Code getSeqTp() {
        return seqTp;
    }

    /**
     * Sets the value of the seqTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType2Code }
     *     
     */
    public void setSeqTp(SequenceType2Code value) {
        this.seqTp = value;
    }

    /**
     * Gets the value of the frqcy property.
     * 
     * @return
     *     possible object is
     *     {@link Frequency36Choice }
     *     
     */
    public Frequency36Choice getFrqcy() {
        return frqcy;
    }

    /**
     * Sets the value of the frqcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency36Choice }
     *     
     */
    public void setFrqcy(Frequency36Choice value) {
        this.frqcy = value;
    }

    /**
     * Gets the value of the drtn property.
     * 
     * @return
     *     possible object is
     *     {@link DatePeriodDetails1 }
     *     
     */
    public DatePeriodDetails1 getDrtn() {
        return drtn;
    }

    /**
     * Sets the value of the drtn property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriodDetails1 }
     *     
     */
    public void setDrtn(DatePeriodDetails1 value) {
        this.drtn = value;
    }

    /**
     * Gets the value of the frstColltnDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrstColltnDt() {
        return frstColltnDt;
    }

    /**
     * Sets the value of the frstColltnDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrstColltnDt(XMLGregorianCalendar value) {
        this.frstColltnDt = value;
    }

    /**
     * Gets the value of the fnlColltnDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFnlColltnDt() {
        return fnlColltnDt;
    }

    /**
     * Sets the value of the fnlColltnDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFnlColltnDt(XMLGregorianCalendar value) {
        this.fnlColltnDt = value;
    }

}
