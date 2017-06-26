
package com.centralnaBanka.models.mt103;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.types.mt103 package. 
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

    private final static QName _Rtgs_QNAME = new QName("http://codenotfound.com/types/mt103", "rtgs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.types.mt103
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mt103CT }
     * 
     */
    public Mt103CT createMt103CT() {
        return new Mt103CT();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mt103CT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://codenotfound.com/types/mt103", name = "rtgs")
    public JAXBElement<Mt103CT> createRtgs(Mt103CT value) {
        return new JAXBElement<Mt103CT>(_Rtgs_QNAME, Mt103CT.class, null, value);
    }

}
