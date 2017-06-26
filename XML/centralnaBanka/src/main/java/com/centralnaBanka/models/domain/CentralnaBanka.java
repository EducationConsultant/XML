package com.centralnaBanka.models.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "centralna_banka")
public class CentralnaBanka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "centralna_banka_id", nullable = false, unique = true)
	private Long id;

	@Column(name = "naziv", nullable = false)
	private String naziv;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "centralnaBanka", fetch = FetchType.EAGER)
	public List<Banka> banke;
	
	
	public List<Banka> getBanke() {
		return banke;
	}

	public void setBanke(List<Banka> banke) {
		this.banke = banke;
	}

	public CentralnaBanka() {}

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
	
	
}
