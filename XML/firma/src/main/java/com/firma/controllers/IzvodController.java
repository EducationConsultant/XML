package com.firma.controllers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.websocket.server.PathParam;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import net.sf.saxon.TransformerFactoryImpl;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firma.models.presek.GetPresekResponse;
import com.firma.models.presek.GetPresekResponse.Stavke;
import com.firma.models.presek.GetPresekResponse.Zaglavlje;
import com.firma.models.presek.MyValidationEventHandler;
import com.firma.models.zahtev.GetPresek;
import com.firma.models.zahtev.ZahtevZaDobijanjeIzvodaJSON;

@RestController
@RequestMapping("/api/firma/izvod")
public class IzvodController {
	
 	@RequestMapping(produces= MediaType.TEXT_PLAIN_VALUE, path="izvodTest", method=RequestMethod.GET)
    public String getIzvodTest() {
        
        return "hello";
    }
 	@RequestMapping(produces="application/pdf", path="getIzvodPDF/{zahtev}", method=RequestMethod.GET)
 	
    public ResponseEntity<byte[]> getIzvodPDF(@PathVariable("zahtev") String zahtev) {
        ZahtevZaDobijanjeIzvodaJSON zah=parseZahtevJSON(zahtev);
        File izlaz=null;
        if(zah!=null){

            if(zah.datum==null)
                return new ResponseEntity<byte[]>(HttpStatus.NO_CONTENT);
            System.out.println(zah.brojRacuna);
            System.out.println(zah.datum.toString());
            
            
            GetPresek XMLzahtev=setupXMLRequest(zah);
            if(XMLzahtev==null)
                return new ResponseEntity<byte[]>(HttpStatus.NO_CONTENT);
            
            GetPresekResponse povrat= null;

            povrat=SoapHandleIzvod(XMLzahtev);
            
            
        izlaz=generatePDF(povrat);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response;
		try {
			response = new ResponseEntity<byte[]>(Files.readAllBytes(izlaz.toPath())
			, headers, HttpStatus.OK);
	        return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ResponseEntity<byte[]>(HttpStatus.NO_CONTENT);
    }
 	
 	private File generatePDF(GetPresekResponse povrat) {
        // TODO Auto-generated method stub
 	   File pdfFile=null;
 	   
	 	   try {

	 		  File p = new ClassPathResource("fop.xconf").getFile();
               System.out.println(p);
	            FopFactory fopFactory = FopFactory.newInstance(p);
	            TransformerFactoryImpl transformerFactory = new TransformerFactoryImpl();
                //String catalinaBase= ;
                //String path=catalinaBase+"/webapps/"+getPropertyValue("NazivFirme")+"/WEB-INF/wsdl/";
	 	      File xslFile = new ClassPathResource("schemas/presek.xsl").getFile();//new File(path+"presek.xsl");
	 	  // Create transformation source
	 	        StreamSource transformSource = new StreamSource(xslFile);
	 	        
	 	        // Initialize the transformation subject
	 	       JAXBContext context = JAXBContext.newInstance(GetPresekResponse.class);
	            
	 	       Marshaller marshaller = context.createMarshaller();
	            
	            // Podešavanje marshaller-a
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	            
	            // Umesto System.out-a, može se koristiti FileOutputStream
	            marshaller.setProperty("com.sun.xml.bind.xmlHeaders", 
	                    "<?xml-stylesheet type=\"text/xsl\" href=\"presek.xsl\" ?>\n");
                String path="C:/Temp/";
	            marshaller.marshal(povrat, new FileWriter(new File(path+"out.xml")));
	 	        StreamSource source = new StreamSource(new File(path+"out.xml"));

	 	        // Initialize user agent needed for the transformation
	 	        FOUserAgent userAgent = fopFactory.newFOUserAgent();
	 	        
	 	        // Create the output stream to store the results
	 	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

	 	        // Initialize the XSL-FO transformer object
	 	        Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
	 	        
	 	        // Construct FOP instance with desired output format
	 	        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

	 	        // Resulting SAX events 
	 	        SAXResult res = new SAXResult(fop.getDefaultHandler());

	 	        // Start XSLT transformation and FOP processing
	 	        xslFoTransformer.transform(source, res);

	 	        // Generate PDF file
	 	        pdfFile = new File(path+"out.pdf");
	 	        if (!pdfFile.getParentFile().exists()) {
	 	            System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
	 	            pdfFile.getParentFile().mkdir();
	 	        }
	 	        
	 	        OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
	 	        out.write(outStream.toByteArray());

	 	        System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
	 	        out.close();

        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	 	   return pdfFile;
    }
 	
    @RequestMapping(produces=MediaType.TEXT_PLAIN_VALUE, consumes= MediaType.TEXT_PLAIN_VALUE, path="getIzvod", method=RequestMethod.POST)
    @ResponseBody
    public String getIzvod(@RequestBody String zahtev) {
    	System.out.println("zahtev :"+zahtev);
 	    ZahtevZaDobijanjeIzvodaJSON zah=parseZahtevJSON(zahtev);
        
        String ret="failed";
        if(zah!=null){
                if(zah.datum==null)
                    return "failed";
	        System.out.println(zah.brojRacuna);
	        System.out.println(zah.datum.toString());
	        
	        
	        GetPresek XMLzahtev=setupXMLRequest(zah);
	        if(XMLzahtev==null)
	            return "failed";
	        
	        GetPresekResponse povrat= null;

	        povrat=SoapHandleIzvod(XMLzahtev);
            
	        if(povrat!=null)
	            ret=getReturnValue(povrat);

            }
        return ret;
    }
 	private GetPresekResponse SoapHandleIzvod(GetPresek xMLzahtev) {
        // TODO Auto-generated method stub
        String adresaBanke="http://localhost:9090";//getPropertyValue("AdresaBanke");
 	    System.out.println(adresaBanke);
 	   GetPresekResponse ret= null;
        ArrayList<GetPresekResponse> retVals= new ArrayList<GetPresekResponse>();
        SOAPConnectionFactory soapConnectionFactory;
        SOAPConnection soapConnection = null;
        int presek=1;
        while(true){
            try {
                soapConnectionFactory = SOAPConnectionFactory.newInstance();
                soapConnection= soapConnectionFactory.createConnection();
                String url = adresaBanke+"/services/Izvod";
                MessageFactory messageFactory = MessageFactory.newInstance();
                SOAPMessage soapMessage = messageFactory.createMessage();
                SOAPPart soapPart = soapMessage.getSOAPPart();

                String serverURI = "http://codenotfound.com/services/izvod";

                // SOAP Envelope
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.addNamespaceDeclaration("n0", serverURI);
                envelope.addNamespaceDeclaration("n1", "http://codenotfound.com/types/zahtev");
                SOAPBody soapBody = envelope.getBody();
                SOAPElement soapBodyElem = soapBody.addChildElement("GetPresek", "n1");
                SOAPElement soapBodyElem0 = soapBodyElem.addChildElement("Broj_racuna", "n1");
                SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Datum", "n1");
                soapBodyElem0.addTextNode(xMLzahtev.getBrojRacuna());
                SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Redni_broj_preseka", "n1");
                soapBodyElem1.addTextNode(xMLzahtev.getDatum().toXMLFormat());
                soapBodyElem2.addTextNode(Integer.toString(presek));

                soapMessage.saveChanges();

                /* Print the request message */
                System.out.print("Request SOAP Message = ");
                soapMessage.writeTo(System.out);
                System.out.println();
                SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

                // Process the SOAP Response
                org.w3c.dom.Node sourceContent = soapResponse.getSOAPBody().getFirstChild();
                Source xmlSource = new DOMSource(sourceContent);
                Unmarshaller unmarshaller = JAXBContext.newInstance(GetPresekResponse.class).createUnmarshaller();
                
                SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                String catalinaBase= System.getProperty("catalina.base");
                File schemaFile= new ClassPathResource("schemas/Presek.xsd").getFile();//new File(catalinaBase+"/webapps/"+getPropertyValue("NazivFirme")+"/WEB-INF/wsdl/Presek.xsd");
                Schema schema = schemaFactory.newSchema(schemaFile);
                
                // Podešavanje unmarshaller-a za XML schema validaciju
                unmarshaller.setSchema(schema);
                unmarshaller.setEventHandler(new MyValidationEventHandler());
                ret=unmarshaller.unmarshal(xmlSource, GetPresekResponse.class).getValue();
                
                if(ret.getZaglavlje().getBrojPreseka()==presek)
                    retVals.add(ret);
                
                
            } catch (UnsupportedOperationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SOAPException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JAXBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    soapConnection.close();
                } catch (SOAPException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(retVals==null || ret.getZaglavlje().getBrojPreseka()!=presek)
                    break;
                presek++;
            }
        }
        ret=new GetPresekResponse();
        ret.setZaglavlje(new Zaglavlje());
        ret.setStavke(new Stavke());
        if(retVals.size()>0){
            ret.getZaglavlje().setBrojRacuna(retVals.get(0).getZaglavlje().getBrojRacuna());
            ret.getZaglavlje().setDatumNaloga(retVals.get(0).getZaglavlje().getDatumNaloga());
            ret.getZaglavlje().setNovoStanje(retVals.get(0).getZaglavlje().getNovoStanje());
            ret.getZaglavlje().setPrethodnoStanje(retVals.get(0).getZaglavlje().getPrethodnoStanje());
            ret.getZaglavlje().setBrojPreseka(0);
            ret.getZaglavlje().setBrojPromenaNaTeret(0);
            ret.getZaglavlje().setBrojPromenaUKorist(0);
            ret.getZaglavlje().setUkupnoNaTeret(new BigDecimal(0));
            ret.getZaglavlje().setUkupnoUKorist(new BigDecimal(0));
            
            for(GetPresekResponse pi:retVals){
                ret.getZaglavlje().setBrojPreseka(pi.getZaglavlje().getBrojPreseka());
                ret.getZaglavlje().setBrojPromenaNaTeret(
                        ret.getZaglavlje().getBrojPromenaNaTeret()+pi.getZaglavlje().getBrojPromenaNaTeret());
                ret.getZaglavlje().setBrojPromenaUKorist(
                        ret.getZaglavlje().getBrojPromenaUKorist()+pi.getZaglavlje().getBrojPromenaUKorist());
                ret.getZaglavlje().setUkupnoNaTeret(
                        ret.getZaglavlje().getUkupnoNaTeret().add(pi.getZaglavlje().getUkupnoNaTeret()));
                
                ret.getZaglavlje().setUkupnoUKorist(
                        ret.getZaglavlje().getUkupnoUKorist().add(pi.getZaglavlje().getUkupnoUKorist()));
                
                ret.getStavke().getStavka().addAll(pi.getStavke().getStavka());
            }
        };
        return ret;
    }
    public ZahtevZaDobijanjeIzvodaJSON parseZahtevJSON(String zahtev){
        ObjectMapper ojb=new ObjectMapper();
        ZahtevZaDobijanjeIzvodaJSON zah=null;
 	   try {
           zah = ojb.readValue(zahtev, ZahtevZaDobijanjeIzvodaJSON.class);
       } catch (JsonParseException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (JsonMappingException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
 	   return zah;
 	}
 	public GetPresek setupXMLRequest(ZahtevZaDobijanjeIzvodaJSON zah){
 		GetPresek XMLzahtev=new GetPresek();
       XMLzahtev.setBrojRacuna(zah.brojRacuna);
       
       GregorianCalendar c = new GregorianCalendar();
       c.setTime(zah.datum);
       XMLGregorianCalendar date2=null;
       try {
           date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
       } catch (DatatypeConfigurationException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
           return null;
       }
       XMLzahtev.setDatum(date2);
       return XMLzahtev;
 	}
 	public String getReturnValue(GetPresekResponse povrat){
        ObjectMapper ojb=new ObjectMapper();
        ojb.setDateFormat(SimpleDateFormat.getDateInstance());
 	    String ret="";
 	   try {
           ret=ojb.writeValueAsString(povrat);
       } catch (JsonGenerationException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (JsonMappingException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       System.out.println(ret);
       return ret;
 	}
 	public String getPropertyValue(String val){
 	   String result = "";
 	    InputStream inputStream = null;
 	   try {
            Properties prop = new Properties();
            String propFileName = "application.properties";
 
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
 
            result=prop.getProperty(val);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
 	}
}
