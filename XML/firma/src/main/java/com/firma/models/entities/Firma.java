package com.firma.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int brojRacuna;

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

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

}
