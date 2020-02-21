
package pain._011;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MandateAdjustment1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateAdjustment1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DtAdjstmntRuleInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}TrueFalseIndicator"/>
 *         &lt;element name="Ctgy" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Frequency37Choice" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Rate" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PercentageRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateAdjustment1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "dtAdjstmntRuleInd",
    "ctgy",
    "amt",
    "rate"
})
public class MandateAdjustment1 {

    @XmlElement(name = "DtAdjstmntRuleInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected boolean dtAdjstmntRuleInd;
    @XmlElement(name = "Ctgy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected Frequency37Choice ctgy;
    @XmlElement(name = "Amt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected ActiveCurrencyAndAmount amt;
    @XmlElement(name = "Rate", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected BigDecimal rate;

    /**
     * Gets the value of the dtAdjstmntRuleInd property.
     * 
     */
    public boolean isDtAdjstmntRuleInd() {
        return dtAdjstmntRuleInd;
    }

    /**
     * Sets the value of the dtAdjstmntRuleInd property.
     * 
     */
    public void setDtAdjstmntRuleInd(boolean value) {
        this.dtAdjstmntRuleInd = value;
    }

    /**
     * Gets the value of the ctgy property.
     * 
     * @return
     *     possible object is
     *     {@link Frequency37Choice }
     *     
     */
    public Frequency37Choice getCtgy() {
        return ctgy;
    }

    /**
     * Sets the value of the ctgy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency37Choice }
     *     
     */
    public void setCtgy(Frequency37Choice value) {
        this.ctgy = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

}
