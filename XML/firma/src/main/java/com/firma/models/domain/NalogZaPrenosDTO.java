package com.firma.models.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "nalogzaprenos")
public class NalogZaPrenosDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPoruke", nullable = false, unique = true)
	protected Long idPoruke;

	@Column(name = "duznikNalogodavac", nullable = false)
	@NotNull
	protected String duznikNalogodavac;

	@Column(name = "svrhaPlacanja", nullable = false)
	@NotNull
	protected String svrhaPlacanja;

	@Column(name = "primalacPoverilac", nullable = false)
	@NotNull
	protected String primalacPoverilac;

	@Temporal(TemporalType.DATE)
	@Column(name = "datumNaloga", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	protected Date datumNaloga;

	@Temporal(TemporalType.DATE)
	@Column(name = "datumValute", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	protected Date datumValute;

	@Column(name = "racunDuznika", nullable = false)
	@NotNull
	protected String racunDuznika;

	@Column(name = "modelZaduzenja", nullable = false)
	@NotNull
	protected int modelZaduzenja;

	@Column(name = "pozivNaBrojZaduzenja", nullable = false)
	@NotNull
	protected String pozivNaBrojZaduzenja;

	@Column(name = "racunPoverioca", nullable = false)
	@NotNull
	protected String racunPoverioca;

	@Column(name = "modelOdobrenja", nullable = false)
	@NotNull
	protected int modelOdobrenja;

	@Column(name = "pozivNaBrojOdobrenja", nullable = false)
	@NotNull
	protected String pozivNaBrojOdobrenja;

	@Column(name = "iznos", nullable = false)
	@NotNull
	protected BigDecimal iznos;

	@Column(name = "oznakaValute", nullable = false)
	@NotNull
	protected String oznakaValute;

	@Column(name = "hitno", nullable = false)
	@NotNull
	protected boolean hitno;

	public NalogZaPrenosDTO() {

	}

	public Long getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(Long idPoruke) {
		this.idPoruke = idPoruke;
	}

	public String getDuznikNalogodavac() {
		return duznikNalogodavac;
	}

	public void setDuznikNalogodavac(String duznikNalogodavac) {
		this.duznikNalogodavac = duznikNalogodavac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPrimalacPoverilac() {
		return primalacPoverilac;
	}

	public void setPrimalacPoverilac(String primalacPoverilac) {
		this.primalacPoverilac = primalacPoverilac;
	}

	public Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public int getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public int getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public BigDecimal getIznos() {
		return iznos;
	}

	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}

	public String getOznakaValute() {
		return oznakaValute;
	}

	public void setOznakaValute(String oznakaValute) {
		this.oznakaValute = oznakaValute;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

}
