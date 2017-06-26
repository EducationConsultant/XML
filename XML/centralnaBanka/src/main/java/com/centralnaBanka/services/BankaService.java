package com.centralnaBanka.services;

import java.util.List;

import com.centralnaBanka.models.domain.Banka;



public interface BankaService {

	public Banka save(Long idC, Banka banka);

	public Banka findOne(Long id);

	public List<Banka> find();

	public Banka findByNaziv(String naziv);

}
