package com.firma.models.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stavka")
public class StavkaDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "redniBroj", nullable = false, unique = true)
	private Long redniBroj;

	@Column(name = "nazivRobeIliUsluge", nullable = false)
	private String nazivRobeIliUsluge;

	@Column(name = "kolicina", nullable = false)
	private BigDecimal kolicina;

	@Column(name = "jedinicaMere", nullable = false)
	private String jedinicaMere;

	@Column(name = "jedinicnaCena", nullable = false)
	private BigDecimal jedinicnaCena;

	@Column(name = "vrednost")
	private BigDecimal vrednost;

	@Column(name = "procenatRabata", nullable = false)
	private BigDecimal procenatRabata;

	@Column(name = "iznosRabata")
	private BigDecimal iznosRabata;

	@Column(name = "umanjenoZaRabat")
	private BigDecimal umanjenoZaRabat;

	@Column(name = "ukupanPorez", nullable = false)
	private BigDecimal ukupanPorez;

	@ManyToOne
	@JoinColumn(name = "faktura", referencedColumnName = "IDPoruke")
	@JsonIgnore
	public FakturaDTO faktura;

	public StavkaDTO() {

	}

	public FakturaDTO getFaktura() {
		return faktura;
	}

	public void setFaktura(FakturaDTO faktura) {
		this.faktura = faktura;
	}

	public Long getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(Long redniBroj) {
		this.redniBroj = redniBroj;
	}

	public String getNazivRobeIliUsluge() {
		return nazivRobeIliUsluge;
	}

	public void setNazivRobeIliUsluge(String nazivRobeIliUsluge) {
		this.nazivRobeIliUsluge = nazivRobeIliUsluge;
	}

	public BigDecimal getKolicina() {
		return kolicina;
	}

	public void setKolicina(BigDecimal kolicina) {
		this.kolicina = kolicina;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public BigDecimal getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(BigDecimal jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public BigDecimal getVrednost() {
		return vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public BigDecimal getProcenatRabata() {
		return procenatRabata;
	}

	public void setProcenatRabata(BigDecimal procenatRabata) {
		this.procenatRabata = procenatRabata;
	}

	public BigDecimal getIznosRabata() {
		return iznosRabata;
	}

	public void setIznosRabata(BigDecimal iznosRabata) {
		this.iznosRabata = iznosRabata;
	}

	public BigDecimal getUmanjenoZaRabat() {
		return umanjenoZaRabat;
	}

	public void setUmanjenoZaRabat(BigDecimal umanjenoZaRabat) {
		this.umanjenoZaRabat = umanjenoZaRabat;
	}

	public BigDecimal getUkupanPorez() {
		return ukupanPorez;
	}

	public void setUkupanPorez(BigDecimal ukupanPorez) {
		this.ukupanPorez = ukupanPorez;
	}

}