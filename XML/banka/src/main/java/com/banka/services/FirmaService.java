package com.banka.services;

import java.util.List;

import com.banka.models.domain.Firma;

public interface FirmaService {

	public Firma save(Firma firma);

	public Firma findOne(Long id);

	public List<Firma> find();

	public Firma findByNaziv(String naziv);
}
