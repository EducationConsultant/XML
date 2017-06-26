package com.firma.services;

import java.util.List;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.nalogzaprenos.NalogZaPrenos;

public interface FirmaService {

	public Firma findOne(Long id);

	public Firma save(Firma firma);

	public Firma findByNaziv(String naziv);

	public List<Firma> find();

	public Firma saveFaktura(Long id, FakturaDTO faktura);

	public void posaljiNalog(NalogZaPrenos n);
}
