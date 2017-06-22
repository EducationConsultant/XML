package com.banka.models.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "banka")
public class Banka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banka_id", nullable = false, unique = true)
	private Long id;

	@Column(name = "naziv", nullable = false)
	private String naziv;

	@Column(name = "sifra", nullable = false)
	private int sifra;

	@Column(name = "swiftKod")
	private String swiftKod;

	@Column(name = "obracunskiRacun")
	private String obracunskiRacun;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka")
	@JsonIgnore
	private List<Firma> firme;

	public Banka() {

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

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getSwiftKod() {
		return swiftKod;
	}

	public void setSwiftKod(String swiftKod) {
		this.swiftKod = swiftKod;
	}

	public String getObracunskiRacun() {
		return obracunskiRacun;
	}

	public void setObracunskiRacun(String obracunskiRacun) {
		this.obracunskiRacun = obracunskiRacun;
	}

	public List<Firma> getFirme() {
		return firme;
	}

	public void setFirme(List<Firma> firme) {
		this.firme = firme;
	}

}
