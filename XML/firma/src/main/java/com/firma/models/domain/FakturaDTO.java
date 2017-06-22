package com.firma.models.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "faktura")
public class FakturaDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPoruke", nullable = false, unique = true)
	private Long idPoruke;

	@Column(name = "nazivDobavljaca", nullable = false)
	private String nazivDobavljaca;

	@Column(name = "adresaDobavljaca", nullable = false)
	private String adresaDobavljaca;

	@Column(name = "pibDobavljaca", nullable = false)
	private String pibDobavljaca;

	@Column(name = "nazivKupca", nullable = false)
	private String nazivKupca;

	@Column(name = "adresaKupca", nullable = false)
	private String adresaKupca;

	@Column(name = "pibKupca", nullable = false)
	private String pibKupca;

	@Column(name = "brojRacuna", nullable = false)
	private int brojRacuna;

	@Temporal(TemporalType.DATE)
	@Column(name = "datumRacuna", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date datumRacuna;

	@Column(name = "vrednostRobe")
	private BigDecimal vrednostRobe;

	@Column(name = "vrednostUsluga")
	private BigDecimal vrednostUsluga;

	@Column(name = "ukupnoRobaIUsluge")
	private BigDecimal ukupnoRobaIUsluge;

	@Column(name = "ukupanRabat")
	private BigDecimal ukupanRabat;

	@Column(name = "ukupanPorez")
	private BigDecimal ukupanPorez;

	@Column(name = "oznakaValute", nullable = false)
	private String oznakaValute;

	@Column(name = "iznosZaUplatu")
	private BigDecimal iznosZaUplatu;

	@Column(name = "uplataNaRacun", nullable = false)
	private String uplataNaRacun;

	@Temporal(TemporalType.DATE)
	@Column(name = "datumValute", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date datumValute;

	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<StavkaDTO> stavka;

//	@ManyToOne
//	public Firma firma;
//	
//	

//	public Firma getFirma() {
//		return firma;
//	}
//
//	public void setFirma(Firma firma) {
//		this.firma = firma;
//	}

	public FakturaDTO() {

	}

	public Long getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(Long idPoruke) {
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

	public List<StavkaDTO> getStavka() {
		return stavka;
	}

	public void setStavka(List<StavkaDTO> stavka) {
		this.stavka = stavka;
	}

}
