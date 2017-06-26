
package com.banka.models.mt102;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.types.mt102 package. 
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

    private final static QName _Clearing_QNAME = new QName("http://codenotfound.com/types/mt102", "clearing");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.types.mt102
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NalogZaGrupnaPlacanja }
     * 
     */
    public NalogZaGrupnaPlacanja createNalogZaGrupnaPlacanja() {
        return new NalogZaGrupnaPlacanja();
    }

    /**
     * Create an instance of {@link NalogZaGrupnaPlacanja.Placanja }
     * 
     */
    public NalogZaGrupnaPlacanja.Placanja createNalogZaGrupnaPlacanjaPlacanja() {
        return new NalogZaGrupnaPlacanja.Placanja();
    }

    /**
     * Create an instance of {@link NalogZaGrupnaPlacanja.Placanja.Placanje }
     * 
     */
    public NalogZaGrupnaPlacanja.Placanja.Placanje createNalogZaGrupnaPlacanjaPlacanjaPlacanje() {
        return new NalogZaGrupnaPlacanja.Placanja.Placanje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NalogZaGrupnaPlacanja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://codenotfound.com/types/mt102", name = "clearing")
    public JAXBElement<NalogZaGrupnaPlacanja> createClearing(NalogZaGrupnaPlacanja value) {
        return new JAXBElement<NalogZaGrupnaPlacanja>(_Clearing_QNAME, NalogZaGrupnaPlacanja.class, null, value);
    }

}
