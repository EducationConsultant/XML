
package com.banka.models.mt102;

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
 * <p>Java class for Nalog_za_grupna_placanja complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Nalog_za_grupna_placanja"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID_poruke"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SWIFT_kod_banke_duznika"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obracunski_racun_banke_duznika"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="18"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SWIFT_kod_banke_poverioca"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obracunski_racun_banke_poverioca"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="18"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Ukupan_iznos"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="15"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Sifra_valute"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Datum_Valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Placanja"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Placanje" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ID_naloga_za_placanje"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="50"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
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
 *                             &lt;element name="Racun_duznika"&gt;
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
 *                             &lt;element name="Poziv_na_broj_zaduzenja"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="20"/&gt;
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
 *                             &lt;element name="Model_odobrenja"&gt;
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
 *                             &lt;element name="Ukupan_iznos"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="15"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Sifra_valute"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
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
@XmlRootElement(name="clearing")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Nalog_za_grupna_placanja", propOrder = {
    "idPoruke",
    "swiftKodBankeDuznika",
    "obracunskiRacunBankeDuznika",
    "swiftKodBankePoverioca",
    "obracunskiRacunBankePoverioca",
    "ukupanIznos",
    "sifraValute",
    "datumValute",
    "datum",
    "placanja"
})
public class NalogZaGrupnaPlacanja {

    @XmlElement(name = "ID_poruke", required = true)
    protected String idPoruke;
    @XmlElement(name = "SWIFT_kod_banke_duznika", required = true)
    protected String swiftKodBankeDuznika;
    @XmlElement(name = "Obracunski_racun_banke_duznika", required = true)
    protected String obracunskiRacunBankeDuznika;
    @XmlElement(name = "SWIFT_kod_banke_poverioca", required = true)
    protected String swiftKodBankePoverioca;
    @XmlElement(name = "Obracunski_racun_banke_poverioca", required = true)
    protected String obracunskiRacunBankePoverioca;
    @XmlElement(name = "Ukupan_iznos", required = true)
    protected BigDecimal ukupanIznos;
    @XmlElement(name = "Sifra_valute", required = true)
    protected String sifraValute;
    @XmlElement(name = "Datum_Valute", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;
    @XmlElement(name = "Datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "Placanja", required = true)
    protected NalogZaGrupnaPlacanja.Placanja placanja;

    /**
     * Gets the value of the idPoruke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPoruke() {
        return idPoruke;
    }

    /**
     * Sets the value of the idPoruke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPoruke(String value) {
        this.idPoruke = value;
    }

    /**
     * Gets the value of the swiftKodBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFTKodBankeDuznika() {
        return swiftKodBankeDuznika;
    }

    /**
     * Sets the value of the swiftKodBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFTKodBankeDuznika(String value) {
        this.swiftKodBankeDuznika = value;
    }

    /**
     * Gets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacunBankeDuznika() {
        return obracunskiRacunBankeDuznika;
    }

    /**
     * Sets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacunBankeDuznika(String value) {
        this.obracunskiRacunBankeDuznika = value;
    }

    /**
     * Gets the value of the swiftKodBankePoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFTKodBankePoverioca() {
        return swiftKodBankePoverioca;
    }

    /**
     * Sets the value of the swiftKodBankePoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFTKodBankePoverioca(String value) {
        this.swiftKodBankePoverioca = value;
    }

    /**
     * Gets the value of the obracunskiRacunBankePoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacunBankePoverioca() {
        return obracunskiRacunBankePoverioca;
    }

    /**
     * Sets the value of the obracunskiRacunBankePoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacunBankePoverioca(String value) {
        this.obracunskiRacunBankePoverioca = value;
    }

    /**
     * Gets the value of the ukupanIznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupanIznos() {
        return ukupanIznos;
    }

    /**
     * Sets the value of the ukupanIznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupanIznos(BigDecimal value) {
        this.ukupanIznos = value;
    }

    /**
     * Gets the value of the sifraValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraValute() {
        return sifraValute;
    }

    /**
     * Sets the value of the sifraValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraValute(String value) {
        this.sifraValute = value;
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
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the placanja property.
     * 
     * @return
     *     possible object is
     *     {@link NalogZaGrupnaPlacanja.Placanja }
     *     
     */
    public NalogZaGrupnaPlacanja.Placanja getPlacanja() {
        return placanja;
    }

    /**
     * Sets the value of the placanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link NalogZaGrupnaPlacanja.Placanja }
     *     
     */
    public void setPlacanja(NalogZaGrupnaPlacanja.Placanja value) {
        this.placanja = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="Placanje" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ID_naloga_za_placanje"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="50"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
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
     *                   &lt;element name="Racun_duznika"&gt;
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
     *                   &lt;element name="Poziv_na_broj_zaduzenja"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="20"/&gt;
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
     *                   &lt;element name="Model_odobrenja"&gt;
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
     *                   &lt;element name="Ukupan_iznos"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="15"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Sifra_valute"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
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
        "placanje"
    })
    public static class Placanja {

        @XmlElement(name = "Placanje", required = true)
        protected List<NalogZaGrupnaPlacanja.Placanja.Placanje> placanje;

        /**
         * Gets the value of the placanje property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the placanje property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlacanje().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NalogZaGrupnaPlacanja.Placanja.Placanje }
         * 
         * 
         */
        public List<NalogZaGrupnaPlacanja.Placanja.Placanje> getPlacanje() {
            if (placanje == null) {
                placanje = new ArrayList<NalogZaGrupnaPlacanja.Placanja.Placanje>();
            }
            return this.placanje;
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
         *       &lt;sequence&gt;
         *         &lt;element name="ID_naloga_za_placanje"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="50"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
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
         *         &lt;element name="Racun_duznika"&gt;
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
         *         &lt;element name="Poziv_na_broj_zaduzenja"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="20"/&gt;
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
         *         &lt;element name="Model_odobrenja"&gt;
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
         *         &lt;element name="Ukupan_iznos"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="15"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Sifra_valute"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
            "idNalogaZaPlacanje",
            "duznikNalogodavac",
            "svrhaPlacanja",
            "primalacPoverilac",
            "datumNaloga",
            "racunDuznika",
            "modelZaduzenja",
            "pozivNaBrojZaduzenja",
            "racunPoverioca",
            "modelOdobrenja",
            "pozivNaBrojOdobrenja",
            "ukupanIznos",
            "sifraValute"
        })
        public static class Placanje {

            @XmlElement(name = "ID_naloga_za_placanje", required = true)
            protected String idNalogaZaPlacanje;
            @XmlElement(name = "Duznik-nalogodavac", required = true)
            protected String duznikNalogodavac;
            @XmlElement(name = "Svrha_placanja", required = true)
            protected String svrhaPlacanja;
            @XmlElement(name = "Primalac-poverilac", required = true)
            protected String primalacPoverilac;
            @XmlElement(name = "Datum_naloga", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumNaloga;
            @XmlElement(name = "Racun_duznika", required = true)
            protected String racunDuznika;
            @XmlElement(name = "Model_zaduzenja")
            protected int modelZaduzenja;
            @XmlElement(name = "Poziv_na_broj_zaduzenja", required = true)
            protected String pozivNaBrojZaduzenja;
            @XmlElement(name = "Racun_poverioca", required = true)
            protected String racunPoverioca;
            @XmlElement(name = "Model_odobrenja")
            protected int modelOdobrenja;
            @XmlElement(name = "Poziv_na_broj_odobrenja", required = true)
            protected String pozivNaBrojOdobrenja;
            @XmlElement(name = "Ukupan_iznos", required = true)
            protected BigDecimal ukupanIznos;
            @XmlElement(name = "Sifra_valute", required = true)
            protected String sifraValute;

            /**
             * Gets the value of the idNalogaZaPlacanje property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIDNalogaZaPlacanje() {
                return idNalogaZaPlacanje;
            }

            /**
             * Sets the value of the idNalogaZaPlacanje property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIDNalogaZaPlacanje(String value) {
                this.idNalogaZaPlacanje = value;
            }

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
             * Gets the value of the pozivNaBrojZaduzenja property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPozivNaBrojZaduzenja() {
                return pozivNaBrojZaduzenja;
            }

            /**
             * Sets the value of the pozivNaBrojZaduzenja property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPozivNaBrojZaduzenja(String value) {
                this.pozivNaBrojZaduzenja = value;
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
             * Gets the value of the modelOdobrenja property.
             * 
             */
            public int getModelOdobrenja() {
                return modelOdobrenja;
            }

            /**
             * Sets the value of the modelOdobrenja property.
             * 
             */
            public void setModelOdobrenja(int value) {
                this.modelOdobrenja = value;
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
             * Gets the value of the ukupanIznos property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getUkupanIznos() {
                return ukupanIznos;
            }

            /**
             * Sets the value of the ukupanIznos property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setUkupanIznos(BigDecimal value) {
                this.ukupanIznos = value;
            }

            /**
             * Gets the value of the sifraValute property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSifraValute() {
                return sifraValute;
            }

            /**
             * Sets the value of the sifraValute property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSifraValute(String value) {
                this.sifraValute = value;
            }

        }

    }

}
