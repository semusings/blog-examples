
package pain._011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Mandate9 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mandate9">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Max35Text"/>
 *         &lt;element name="MndtReqId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Max35Text" minOccurs="0"/>
 *         &lt;element name="Authntcn" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateAuthentication1" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateTypeInformation2" minOccurs="0"/>
 *         &lt;element name="Ocrncs" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateOccurrences4" minOccurs="0"/>
 *         &lt;element name="TrckgInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}TrueFalseIndicator"/>
 *         &lt;element name="FrstColltnAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="ColltnAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="MaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Adjstmnt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateAdjustment1" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}MandateSetupReason1Choice" minOccurs="0"/>
 *         &lt;element name="CdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PartyIdentification43" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PartyIdentification43"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}CashAccount24" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}BranchAndFinancialInstitutionIdentification5" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PartyIdentification43" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PartyIdentification43"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}CashAccount24" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}BranchAndFinancialInstitutionIdentification5"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PartyIdentification43" minOccurs="0"/>
 *         &lt;element name="MndtRef" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}Max35Text" minOccurs="0"/>
 *         &lt;element name="RfrdDoc" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}ReferredMandateDocument1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mandate9", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", propOrder = {
    "mndtId",
    "mndtReqId",
    "authntcn",
    "tp",
    "ocrncs",
    "trckgInd",
    "frstColltnAmt",
    "colltnAmt",
    "maxAmt",
    "adjstmnt",
    "rsn",
    "cdtrSchmeId",
    "cdtr",
    "cdtrAcct",
    "cdtrAgt",
    "ultmtCdtr",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "ultmtDbtr",
    "mndtRef",
    "rfrdDoc"
})
public class Mandate9 {

    @XmlElement(name = "MndtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected String mndtId;
    @XmlElement(name = "MndtReqId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected String mndtReqId;
    @XmlElement(name = "Authntcn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected MandateAuthentication1 authntcn;
    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected MandateTypeInformation2 tp;
    @XmlElement(name = "Ocrncs", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected MandateOccurrences4 ocrncs;
    @XmlElement(name = "TrckgInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected boolean trckgInd;
    @XmlElement(name = "FrstColltnAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected ActiveOrHistoricCurrencyAndAmount frstColltnAmt;
    @XmlElement(name = "ColltnAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected ActiveOrHistoricCurrencyAndAmount colltnAmt;
    @XmlElement(name = "MaxAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected ActiveOrHistoricCurrencyAndAmount maxAmt;
    @XmlElement(name = "Adjstmnt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected MandateAdjustment1 adjstmnt;
    @XmlElement(name = "Rsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected MandateSetupReason1Choice rsn;
    @XmlElement(name = "CdtrSchmeId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected PartyIdentification43 cdtrSchmeId;
    @XmlElement(name = "Cdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected PartyIdentification43 cdtr;
    @XmlElement(name = "CdtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected CashAccount24 cdtrAcct;
    @XmlElement(name = "CdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected BranchAndFinancialInstitutionIdentification5 cdtrAgt;
    @XmlElement(name = "UltmtCdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected PartyIdentification43 ultmtCdtr;
    @XmlElement(name = "Dbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected PartyIdentification43 dbtr;
    @XmlElement(name = "DbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected CashAccount24 dbtrAcct;
    @XmlElement(name = "DbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05", required = true)
    protected BranchAndFinancialInstitutionIdentification5 dbtrAgt;
    @XmlElement(name = "UltmtDbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected PartyIdentification43 ultmtDbtr;
    @XmlElement(name = "MndtRef", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected String mndtRef;
    @XmlElement(name = "RfrdDoc", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.011.001.05")
    protected List<ReferredMandateDocument1> rfrdDoc;

    /**
     * Gets the value of the mndtId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtId() {
        return mndtId;
    }

    /**
     * Sets the value of the mndtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtId(String value) {
        this.mndtId = value;
    }

    /**
     * Gets the value of the mndtReqId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtReqId() {
        return mndtReqId;
    }

    /**
     * Sets the value of the mndtReqId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtReqId(String value) {
        this.mndtReqId = value;
    }

    /**
     * Gets the value of the authntcn property.
     * 
     * @return
     *     possible object is
     *     {@link MandateAuthentication1 }
     *     
     */
    public MandateAuthentication1 getAuthntcn() {
        return authntcn;
    }

    /**
     * Sets the value of the authntcn property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateAuthentication1 }
     *     
     */
    public void setAuthntcn(MandateAuthentication1 value) {
        this.authntcn = value;
    }

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public MandateTypeInformation2 getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public void setTp(MandateTypeInformation2 value) {
        this.tp = value;
    }

    /**
     * Gets the value of the ocrncs property.
     * 
     * @return
     *     possible object is
     *     {@link MandateOccurrences4 }
     *     
     */
    public MandateOccurrences4 getOcrncs() {
        return ocrncs;
    }

    /**
     * Sets the value of the ocrncs property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateOccurrences4 }
     *     
     */
    public void setOcrncs(MandateOccurrences4 value) {
        this.ocrncs = value;
    }

    /**
     * Gets the value of the trckgInd property.
     * 
     */
    public boolean isTrckgInd() {
        return trckgInd;
    }

    /**
     * Sets the value of the trckgInd property.
     * 
     */
    public void setTrckgInd(boolean value) {
        this.trckgInd = value;
    }

    /**
     * Gets the value of the frstColltnAmt property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getFrstColltnAmt() {
        return frstColltnAmt;
    }

    /**
     * Sets the value of the frstColltnAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setFrstColltnAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.frstColltnAmt = value;
    }

    /**
     * Gets the value of the colltnAmt property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getColltnAmt() {
        return colltnAmt;
    }

    /**
     * Sets the value of the colltnAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setColltnAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.colltnAmt = value;
    }

    /**
     * Gets the value of the maxAmt property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getMaxAmt() {
        return maxAmt;
    }

    /**
     * Sets the value of the maxAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setMaxAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.maxAmt = value;
    }

    /**
     * Gets the value of the adjstmnt property.
     * 
     * @return
     *     possible object is
     *     {@link MandateAdjustment1 }
     *     
     */
    public MandateAdjustment1 getAdjstmnt() {
        return adjstmnt;
    }

    /**
     * Sets the value of the adjstmnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateAdjustment1 }
     *     
     */
    public void setAdjstmnt(MandateAdjustment1 value) {
        this.adjstmnt = value;
    }

    /**
     * Gets the value of the rsn property.
     * 
     * @return
     *     possible object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public MandateSetupReason1Choice getRsn() {
        return rsn;
    }

    /**
     * Sets the value of the rsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public void setRsn(MandateSetupReason1Choice value) {
        this.rsn = value;
    }

    /**
     * Gets the value of the cdtrSchmeId property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getCdtrSchmeId() {
        return cdtrSchmeId;
    }

    /**
     * Sets the value of the cdtrSchmeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setCdtrSchmeId(PartyIdentification43 value) {
        this.cdtrSchmeId = value;
    }

    /**
     * Gets the value of the cdtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getCdtr() {
        return cdtr;
    }

    /**
     * Sets the value of the cdtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setCdtr(PartyIdentification43 value) {
        this.cdtr = value;
    }

    /**
     * Gets the value of the cdtrAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * Sets the value of the cdtrAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setCdtrAcct(CashAccount24 value) {
        this.cdtrAcct = value;
    }

    /**
     * Gets the value of the cdtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * Sets the value of the cdtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification5 value) {
        this.cdtrAgt = value;
    }

    /**
     * Gets the value of the ultmtCdtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * Sets the value of the ultmtCdtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setUltmtCdtr(PartyIdentification43 value) {
        this.ultmtCdtr = value;
    }

    /**
     * Gets the value of the dbtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getDbtr() {
        return dbtr;
    }

    /**
     * Sets the value of the dbtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setDbtr(PartyIdentification43 value) {
        this.dbtr = value;
    }

    /**
     * Gets the value of the dbtrAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount24 }
     *     
     */
    public CashAccount24 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * Sets the value of the dbtrAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount24 }
     *     
     */
    public void setDbtrAcct(CashAccount24 value) {
        this.dbtrAcct = value;
    }

    /**
     * Gets the value of the dbtrAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * Sets the value of the dbtrAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification5 value) {
        this.dbtrAgt = value;
    }

    /**
     * Gets the value of the ultmtDbtr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * Sets the value of the ultmtDbtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setUltmtDbtr(PartyIdentification43 value) {
        this.ultmtDbtr = value;
    }

    /**
     * Gets the value of the mndtRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtRef() {
        return mndtRef;
    }

    /**
     * Sets the value of the mndtRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtRef(String value) {
        this.mndtRef = value;
    }

    /**
     * Gets the value of the rfrdDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rfrdDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRfrdDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferredMandateDocument1 }
     * 
     * 
     */
    public List<ReferredMandateDocument1> getRfrdDoc() {
        if (rfrdDoc == null) {
            rfrdDoc = new ArrayList<ReferredMandateDocument1>();
        }
        return this.rfrdDoc;
    }

}
