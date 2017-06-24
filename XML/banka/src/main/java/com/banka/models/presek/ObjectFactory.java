
package com.banka.models.presek;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.types.presek package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.types.presek
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPresekResponse }
     * 
     */
    public GetPresekResponse createGetPresekResponse() {
        return new GetPresekResponse();
    }

    /**
     * Create an instance of {@link GetPresekResponse.Stavke }
     * 
     */
    public GetPresekResponse.Stavke createGetPresekResponseStavke() {
        return new GetPresekResponse.Stavke();
    }

    /**
     * Create an instance of {@link GetPresekResponse.Zaglavlje }
     * 
     */
    public GetPresekResponse.Zaglavlje createGetPresekResponseZaglavlje() {
        return new GetPresekResponse.Zaglavlje();
    }

    /**
     * Create an instance of {@link GetPresekResponse.Stavke.Stavka }
     * 
     */
    public GetPresekResponse.Stavke.Stavka createGetPresekResponseStavkeStavka() {
        return new GetPresekResponse.Stavke.Stavka();
    }

}
