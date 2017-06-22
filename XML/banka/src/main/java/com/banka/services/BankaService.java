package com.banka.services;

import java.util.List;

import com.banka.models.domain.Banka;
import com.banka.models.domain.Firma;

public interface BankaService {

	public Banka save(Banka banka);

	public Banka findOne(Long id);

	public List<Banka> find();

	public Banka findByNaziv(String naziv);

	public Banka saveFirma(Long id, Firma firma);

}
