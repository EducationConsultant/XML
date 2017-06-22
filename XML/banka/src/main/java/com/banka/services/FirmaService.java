package com.banka.services;

import java.util.List;

import com.banka.models.domain.FakturaDTO;
import com.banka.models.domain.Firma;

public interface FirmaService {

	public Firma findOne(Long id);

	public Firma save(Firma firma);

	public Firma findByNaziv(String naziv);

	public List<Firma> find();

	public Firma saveFaktura(Long id, FakturaDTO faktura);

	public Firma sendFaktura(Long id1, Long id2, FakturaDTO faktura);
}
