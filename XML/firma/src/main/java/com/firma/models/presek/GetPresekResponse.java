
package com.firma.models.presek;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Zaglavlje"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="Broj_racuna"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;length value="18"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Datum_naloga"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Broj_preseka"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                         &lt;totalDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Prethodno_stanje"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="15"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Broj_promena_u_korist"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                         &lt;totalDigits value="6"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Ukupno_u_korist"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="15"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Broj_promena_na_teret"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                         &lt;totalDigits value="6"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Ukupno_na_teret"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="15"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Novo_stanje"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="15"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Stavke"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="Stavka"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="Duznik-nalogodavac"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="255"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Svrha_placanja"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="255"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Primalac-poverilac"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="255"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="Datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="Racun_duznika"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Racun_poverioca"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Model_zaduzenja"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                                   &lt;totalDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Poziv_na_broj_odobrenja"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Iznos"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="15"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Smer"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "zaglavlje",
    "stavke"
})
@XmlRootElement(name = "GetPresekResponse")
public class GetPresekResponse {

    @XmlElement(name = "Zaglavlje", required = true)
    protected GetPresekResponse.Zaglavlje zaglavlje;
    @XmlElement(name = "Stavke", required = true)
    protected GetPresekResponse.Stavke stavke;

    /**
     * Gets the value of the zaglavlje property.
     * 
     * @return
     *     possible object is
     *     {@link GetPresekResponse.Zaglavlje }
     *     
     */
    public GetPresekResponse.Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    /**
     * Sets the value of the zaglavlje property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPresekResponse.Zaglavlje }
     *     
     */
    public void setZaglavlje(GetPresekResponse.Zaglavlje value) {
        this.zaglavlje = value;
    }

    /**
     * Gets the value of the stavke property.
     * 
     * @return
     *     possible object is
     *     {@link GetPresekResponse.Stavke }
     *     
     */
    public GetPresekResponse.Stavke getStavke() {
        return stavke;
    }

    /**
     * Sets the value of the stavke property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPresekResponse.Stavke }
     *     
     */
    public void setStavke(GetPresekResponse.Stavke value) {
        this.stavke = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element name="Stavka"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="Duznik-nalogodavac"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="255"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Svrha_placanja"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="255"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Primalac-poverilac"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="255"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="Datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="Racun_duznika"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Racun_poverioca"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Model_zaduzenja"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *                         &lt;totalDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Poziv_na_broj_odobrenja"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Iznos"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="15"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Smer"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "stavka"
    })
    public static class Stavke {

        @XmlElement(name = "Stavka", required = true)
        protected List<GetPresekResponse.Stavke.Stavka> stavka;

        /**
         * Gets the value of the stavka property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stavka property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStavka().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetPresekResponse.Stavke.Stavka }
         * 
         * 
         */
        public List<GetPresekResponse.Stavke.Stavka> getStavka() {
            if (stavka == null) {
                stavka = new ArrayList<GetPresekResponse.Stavke.Stavka>();
            }
            return this.stavka;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;all&gt;
         *         &lt;element name="Duznik-nalogodavac"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="255"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Svrha_placanja"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="255"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Primalac-poverilac"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="255"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="Datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="Racun_duznika"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Racun_poverioca"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Model_zaduzenja"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
         *               &lt;totalDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Poziv_na_broj_odobrenja"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="20"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Iznos"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="15"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Smer"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *       &lt;/all&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class Stavka {

            @XmlElement(name = "Duznik-nalogodavac", required = true)
            protected String duznikNalogodavac;
            @XmlElement(name = "Svrha_placanja", required = true)
            protected String svrhaPlacanja;
            @XmlElement(name = "Primalac-poverilac", required = true)
            protected String primalacPoverilac;
            @XmlElement(name = "Datum_naloga", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumNaloga;
            @XmlElement(name = "Datum_valute", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumValute;
            @XmlElement(name = "Racun_duznika", required = true)
            protected String racunDuznika;
            @XmlElement(name = "Racun_poverioca", required = true)
            protected String racunPoverioca;
            @XmlElement(name = "Model_zaduzenja")
            protected int modelZaduzenja;
            @XmlElement(name = "Poziv_na_broj_odobrenja", required = true)
            protected String pozivNaBrojOdobrenja;
            @XmlElement(name = "Iznos", required = true)
            protected BigDecimal iznos;
            @XmlElement(name = "Smer", required = true)
            protected String smer;

            /**
             * Gets the value of the duznikNalogodavac property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDuznikNalogodavac() {
                return duznikNalogodavac;
            }

            /**
             * Sets the value of the duznikNalogodavac property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDuznikNalogodavac(String value) {
                this.duznikNalogodavac = value;
            }

            /**
             * Gets the value of the svrhaPlacanja property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSvrhaPlacanja() {
                return svrhaPlacanja;
            }

            /**
             * Sets the value of the svrhaPlacanja property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSvrhaPlacanja(String value) {
                this.svrhaPlacanja = value;
            }

            /**
             * Gets the value of the primalacPoverilac property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrimalacPoverilac() {
                return primalacPoverilac;
            }

            /**
             * Sets the value of the primalacPoverilac property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrimalacPoverilac(String value) {
                this.primalacPoverilac = value;
            }

            /**
             * Gets the value of the datumNaloga property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDatumNaloga() {
                return datumNaloga;
            }

            /**
             * Sets the value of the datumNaloga property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDatumNaloga(XMLGregorianCalendar value) {
                this.datumNaloga = value;
            }

            /**
             * Gets the value of the datumValute property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDatumValute() {
                return datumValute;
            }

            /**
             * Sets the value of the datumValute property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDatumValute(XMLGregorianCalendar value) {
                this.datumValute = value;
            }

            /**
             * Gets the value of the racunDuznika property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRacunDuznika() {
                return racunDuznika;
            }

            /**
             * Sets the value of the racunDuznika property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRacunDuznika(String value) {
                this.racunDuznika = value;
            }

            /**
             * Gets the value of the racunPoverioca property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRacunPoverioca() {
                return racunPoverioca;
            }

            /**
             * Sets the value of the racunPoverioca property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRacunPoverioca(String value) {
                this.racunPoverioca = value;
            }

            /**
             * Gets the value of the modelZaduzenja property.
             * 
             */
            public int getModelZaduzenja() {
                return modelZaduzenja;
            }

            /**
             * Sets the value of the modelZaduzenja property.
             * 
             */
            public void setModelZaduzenja(int value) {
                this.modelZaduzenja = value;
            }

            /**
             * Gets the value of the pozivNaBrojOdobrenja property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPozivNaBrojOdobrenja() {
                return pozivNaBrojOdobrenja;
            }

            /**
             * Sets the value of the pozivNaBrojOdobrenja property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPozivNaBrojOdobrenja(String value) {
                this.pozivNaBrojOdobrenja = value;
            }

            /**
             * Gets the value of the iznos property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getIznos() {
                return iznos;
            }

            /**
             * Sets the value of the iznos property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setIznos(BigDecimal value) {
                this.iznos = value;
            }

            /**
             * Gets the value of the smer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSmer() {
                return smer;
            }

            /**
             * Sets the value of the smer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSmer(String value) {
                this.smer = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="Broj_racuna"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;length value="18"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Datum_naloga"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Broj_preseka"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *               &lt;totalDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Prethodno_stanje"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="15"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Broj_promena_u_korist"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *               &lt;totalDigits value="6"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Ukupno_u_korist"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="15"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Broj_promena_na_teret"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *               &lt;totalDigits value="6"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Ukupno_na_teret"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="15"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Novo_stanje"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="15"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Zaglavlje {

        @XmlElement(name = "Broj_racuna", required = true)
        protected String brojRacuna;
        @XmlElement(name = "Datum_naloga", required = true)
        protected XMLGregorianCalendar datumNaloga;
        @XmlElement(name = "Broj_preseka")
        protected int brojPreseka;
        @XmlElement(name = "Prethodno_stanje", required = true)
        protected BigDecimal prethodnoStanje;
        @XmlElement(name = "Broj_promena_u_korist")
        protected int brojPromenaUKorist;
        @XmlElement(name = "Ukupno_u_korist", required = true)
        protected BigDecimal ukupnoUKorist;
        @XmlElement(name = "Broj_promena_na_teret")
        protected int brojPromenaNaTeret;
        @XmlElement(name = "Ukupno_na_teret", required = true)
        protected BigDecimal ukupnoNaTeret;
        @XmlElement(name = "Novo_stanje", required = true)
        protected BigDecimal novoStanje;

        /**
         * Gets the value of the brojRacuna property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojRacuna() {
            return brojRacuna;
        }

        /**
         * Sets the value of the brojRacuna property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojRacuna(String value) {
            this.brojRacuna = value;
        }

        /**
         * Gets the value of the datumNaloga property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumNaloga() {
            return datumNaloga;
        }

        /**
         * Sets the value of the datumNaloga property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumNaloga(XMLGregorianCalendar value) {
            this.datumNaloga = value;
        }

        /**
         * Gets the value of the brojPreseka property.
         * 
         */
        public int getBrojPreseka() {
            return brojPreseka;
        }

        /**
         * Sets the value of the brojPreseka property.
         * 
         */
        public void setBrojPreseka(int value) {
            this.brojPreseka = value;
        }

        /**
         * Gets the value of the prethodnoStanje property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPrethodnoStanje() {
            return prethodnoStanje;
        }

        /**
         * Sets the value of the prethodnoStanje property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPrethodnoStanje(BigDecimal value) {
            this.prethodnoStanje = value;
        }

        /**
         * Gets the value of the brojPromenaUKorist property.
         * 
         */
        public int getBrojPromenaUKorist() {
            return brojPromenaUKorist;
        }

        /**
         * Sets the value of the brojPromenaUKorist property.
         * 
         */
        public void setBrojPromenaUKorist(int value) {
            this.brojPromenaUKorist = value;
        }

        /**
         * Gets the value of the ukupnoUKorist property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUkupnoUKorist() {
            return ukupnoUKorist;
        }

        /**
         * Sets the value of the ukupnoUKorist property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUkupnoUKorist(BigDecimal value) {
            this.ukupnoUKorist = value;
        }

        /**
         * Gets the value of the brojPromenaNaTeret property.
         * 
         */
        public int getBrojPromenaNaTeret() {
            return brojPromenaNaTeret;
        }

        /**
         * Sets the value of the brojPromenaNaTeret property.
         * 
         */
        public void setBrojPromenaNaTeret(int value) {
            this.brojPromenaNaTeret = value;
        }

        /**
         * Gets the value of the ukupnoNaTeret property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUkupnoNaTeret() {
            return ukupnoNaTeret;
        }

        /**
         * Sets the value of the ukupnoNaTeret property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUkupnoNaTeret(BigDecimal value) {
            this.ukupnoNaTeret = value;
        }

        /**
         * Gets the value of the novoStanje property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNovoStanje() {
            return novoStanje;
        }

        /**
         * Sets the value of the novoStanje property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNovoStanje(BigDecimal value) {
            this.novoStanje = value;
        }

    }

}
