package com.firma.services;

import java.util.List;

import com.firma.models.domain.Banka;

public interface BankaService {

	public Banka save(Banka banka);

	public Banka findOne(Long id);

	public List<Banka> find();

	public Banka findByNaziv(String naziv);

}
