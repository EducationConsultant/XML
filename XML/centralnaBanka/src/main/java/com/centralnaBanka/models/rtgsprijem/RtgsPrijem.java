
package com.centralnaBanka.models.rtgsprijem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.centralnaBanka.models.mt103.Mt103CT;
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
 *         &lt;element name="mt103" type="{http://codenotfound.com/types/mt103}mt103CT"/&gt;
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
    "mt103",
    "mt910"
})
@XmlRootElement(name = "rtgsPrijem")
public class RtgsPrijem {

    @XmlElement(required = true)
    protected Mt103CT mt103;
    @XmlElement(required = true)
    protected MT910CT mt910;

    /**
     * Gets the value of the mt103 property.
     * 
     * @return
     *     possible object is
     *     {@link Mt103CT }
     *     
     */
    public Mt103CT getMt103() {
        return mt103;
    }

    /**
     * Sets the value of the mt103 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mt103CT }
     *     
     */
    public void setMt103(Mt103CT value) {
        this.mt103 = value;
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
