package com.firma.models.faktura;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zaglavlje")
public class ZaglavljeClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zaglavlje_id", nullable = false, unique = true)
	private Long idZaglavlja;

	@Column(name = "idPoruke", nullable = false, unique = true)
	private String idPoruke;

	@Column(name = "nazivDobavljaca", nullable = false, unique = true)
	private String nazivDobavljaca;

	@Column(name = "adresaDobavljaca", nullable = false, unique = true)
	private String adresaDobavljaca;

	@Column(name = "pibDobavljaca", nullable = false, unique = true)
	private String pibDobavljaca;

	@Column(name = "nazivKupca", nullable = false, unique = true)
	private String nazivKupca;

	@Column(name = "adresaKupca", nullable = false, unique = true)
	private String adresaKupca;

	@Column(name = "pibKupca", nullable = false, unique = true)
	private String pibKupca;

	@Column(name = "brojRacuna", nullable = false, unique = true)
	private int brojRacuna;

	@Column(name = "datumRacuna", nullable = false, unique = true)
	private Date datumRacuna;

	@Column(name = "vrednostRobe", nullable = false, unique = true)
	private BigDecimal vrednostRobe;

	@Column(name = "vrednostUsluga", nullable = false, unique = true)
	private BigDecimal vrednostUsluga;

	@Column(name = "ukupnoRobaIUsluge", nullable = false, unique = true)
	private BigDecimal ukupnoRobaIUsluge;

	@Column(name = "ukupanRabat", nullable = false, unique = true)
	private BigDecimal ukupanRabat;

	@Column(name = "ukupanPorez", nullable = false, unique = true)
	private BigDecimal ukupanPorez;

	@Column(name = "oznakaValute", nullable = false, unique = true)
	private String oznakaValute;

	@Column(name = "iznosZaUplatu", nullable = false, unique = true)
	private BigDecimal iznosZaUplatu;

	@Column(name = "uplataNaRacun", nullable = false, unique = true)
	private String uplataNaRacun;

	@Column(name = "datumValute", nullable = false, unique = true)
	private Date datumValute;

	public ZaglavljeClass() {

	}

	public ZaglavljeClass(String idPoruke, String nazivDobavljaca, String adresaDobavljaca, String pibDobavljaca,
			String nazivKupca, String adresaKupca, String pibKupca, int brojRacuna, Date datumRacuna,
			BigDecimal vrednostRobe, BigDecimal vrednostUsluga, BigDecimal ukupnoRobaIUsluge, BigDecimal ukupanRabat,
			BigDecimal ukupanPorez, String oznakaValute, BigDecimal iznosZaUplatu, String uplataNaRacun,
			Date datumValute) {
		super();
		this.idPoruke = idPoruke;
		this.nazivDobavljaca = nazivDobavljaca;
		this.adresaDobavljaca = adresaDobavljaca;
		this.pibDobavljaca = pibDobavljaca;
		this.nazivKupca = nazivKupca;
		this.adresaKupca = adresaKupca;
		this.pibKupca = pibKupca;
		this.brojRacuna = brojRacuna;
		this.datumRacuna = datumRacuna;
		this.vrednostRobe = vrednostRobe;
		this.vrednostUsluga = vrednostUsluga;
		this.ukupnoRobaIUsluge = ukupnoRobaIUsluge;
		this.ukupanRabat = ukupanRabat;
		this.ukupanPorez = ukupanPorez;
		this.oznakaValute = oznakaValute;
		this.iznosZaUplatu = iznosZaUplatu;
		this.uplataNaRacun = uplataNaRacun;
		this.datumValute = datumValute;
	}

	public String getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(String idPoruke) {
		this.idPoruke = idPoruke;
	}

	public String getNazivDobavljaca() {
		return nazivDobavljaca;
	}

	public void setNazivDobavljaca(String nazivDobavljaca) {
		this.nazivDobavljaca = nazivDobavljaca;
	}

	public String getAdresaDobavljaca() {
		return adresaDobavljaca;
	}

	public void setAdresaDobavljaca(String adresaDobavljaca) {
		this.adresaDobavljaca = adresaDobavljaca;
	}

	public String getPibDobavljaca() {
		return pibDobavljaca;
	}

	public void setPibDobavljaca(String pibDobavljaca) {
		this.pibDobavljaca = pibDobavljaca;
	}

	public String getNazivKupca() {
		return nazivKupca;
	}

	public void setNazivKupca(String nazivKupca) {
		this.nazivKupca = nazivKupca;
	}

	public String getAdresaKupca() {
		return adresaKupca;
	}

	public void setAdresaKupca(String adresaKupca) {
		this.adresaKupca = adresaKupca;
	}

	public String getPibKupca() {
		return pibKupca;
	}

	public void setPibKupca(String pibKupca) {
		this.pibKupca = pibKupca;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumRacuna() {
		return datumRacuna;
	}

	public void setDatumRacuna(Date datumRacuna) {
		this.datumRacuna = datumRacuna;
	}

	public BigDecimal getVrednostRobe() {
		return vrednostRobe;
	}

	public void setVrednostRobe(BigDecimal vrednostRobe) {
		this.vrednostRobe = vrednostRobe;
	}

	public BigDecimal getVrednostUsluga() {
		return vrednostUsluga;
	}

	public void setVrednostUsluga(BigDecimal vrednostUsluga) {
		this.vrednostUsluga = vrednostUsluga;
	}

	public BigDecimal getUkupnoRobaIUsluge() {
		return ukupnoRobaIUsluge;
	}

	public void setUkupnoRobaIUsluge(BigDecimal ukupnoRobaIUsluge) {
		this.ukupnoRobaIUsluge = ukupnoRobaIUsluge;
	}

	public BigDecimal getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(BigDecimal ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public BigDecimal getUkupanPorez() {
		return ukupanPorez;
	}

	public void setUkupanPorez(BigDecimal ukupanPorez) {
		this.ukupanPorez = ukupanPorez;
	}

	public String getOznakaValute() {
		return oznakaValute;
	}

	public void setOznakaValute(String oznakaValute) {
		this.oznakaValute = oznakaValute;
	}

	public BigDecimal getIznosZaUplatu() {
		return iznosZaUplatu;
	}

	public void setIznosZaUplatu(BigDecimal iznosZaUplatu) {
		this.iznosZaUplatu = iznosZaUplatu;
	}

	public String getUplataNaRacun() {
		return uplataNaRacun;
	}

	public void setUplataNaRacun(String uplataNaRacun) {
		this.uplataNaRacun = uplataNaRacun;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

}
