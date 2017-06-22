package com.firma.services;

import java.util.List;

import com.firma.models.domain.Firma;

public interface FirmaService {

	public Firma findOne(Long id);
	public Firma save(Firma firma);
	public Firma findByNaziv(String naziv);
	public List<Firma> find();
}
