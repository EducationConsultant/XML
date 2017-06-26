
package com.banka.models.mt910;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.types.mt910 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RTGSMT910_QNAME = new QName("http://codenotfound.com/types/mt910", "RTGS_MT910");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.types.mt910
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MT910CT }
     * 
     */
    public MT910CT createMT910CT() {
        return new MT910CT();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT910CT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://codenotfound.com/types/mt910", name = "RTGS_MT910")
    public JAXBElement<MT910CT> createRTGSMT910(MT910CT value) {
        return new JAXBElement<MT910CT>(_RTGSMT910_QNAME, MT910CT.class, null, value);
    }

}
