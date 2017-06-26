
package com.banka.services.rtgsprijem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.banka.models.mt103.Mt103CT;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.services.rtgsprijem package. 
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

    private final static QName _RtgsPrijem_QNAME = new QName("http://codenotfound.com/services/rtgsPrijem", "rtgsPrijem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.services.rtgsprijem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mt103CT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://codenotfound.com/services/rtgsPrijem", name = "rtgsPrijem")
    public JAXBElement<Mt103CT> createRtgsPrijem(Mt103CT value) {
        return new JAXBElement<Mt103CT>(_RtgsPrijem_QNAME, Mt103CT.class, null, value);
    }

}
