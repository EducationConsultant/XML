
package com.centralnaBanka.models.clearingprijem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.centralnaBanka.models.mt102.NalogZaGrupnaPlacanja;
import com.centralnaBanka.models.mt910.MT910CT;




/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mt102" type="{http://codenotfound.com/types/mt102}Nalog_za_grupna_placanja"/&gt;
 *         &lt;element name="mt910" type="{http://codenotfound.com/types/mt910}MT910CT"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mt102",
    "mt910"
})
@XmlRootElement(name = "clearingPrijem")
public class ClearingPrijem {

    @XmlElement(required = true)
    protected NalogZaGrupnaPlacanja mt102;
    @XmlElement(required = true)
    protected MT910CT mt910;

    /**
     * Gets the value of the mt102 property.
     * 
     * @return
     *     possible object is
     *     {@link NalogZaGrupnaPlacanja }
     *     
     */
    public NalogZaGrupnaPlacanja getMt102() {
        return mt102;
    }

    /**
     * Sets the value of the mt102 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NalogZaGrupnaPlacanja }
     *     
     */
    public void setMt102(NalogZaGrupnaPlacanja value) {
        this.mt102 = value;
    }

    /**
     * Gets the value of the mt910 property.
     * 
     * @return
     *     possible object is
     *     {@link MT910CT }
     *     
     */
    public MT910CT getMt910() {
        return mt910;
    }

    /**
     * Sets the value of the mt910 property.
     * 
     * @param value
     *     allowed object is
     *     {@link MT910CT }
     *     
     */
    public void setMt910(MT910CT value) {
        this.mt910 = value;
    }

}
