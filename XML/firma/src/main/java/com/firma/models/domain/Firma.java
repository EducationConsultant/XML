package com.firma.models.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "firma")
public class Firma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "firma_id", nullable = false, unique = true)
	private Long id;

	@Column(name = "naziv", nullable = false, unique = true)
	private String naziv;

	@Column(name = "adresa", nullable = false, unique = false)
	private String adresa;

	@Column(name = "pib", nullable = false, unique = true)
	private String pib;

	@Column(name = "brojRacuna", nullable = false, unique = true)
	private String brojRacuna;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "firma", fetch = FetchType.EAGER)
	public List<FakturaDTO> fakture;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="banka_id")
	public Banka banka;


	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public List<FakturaDTO> getFakture() {
		return fakture;
	}

	public void setFakture(List<FakturaDTO> fakture) {
		this.fakture = fakture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Firma() {
	}
}
