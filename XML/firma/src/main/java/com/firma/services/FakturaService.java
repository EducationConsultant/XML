package com.firma.services;

import java.util.List;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.models.faktura.Faktura;

public interface FakturaService {
	public FakturaDTO save(FakturaDTO faktura);

	public FakturaDTO findOne(Long id);

	public List<FakturaDTO> find();

	public FakturaDTO saveStavka(Long id, StavkaDTO stavka);
	
	public List<FakturaDTO> findByFirma(Firma firma);
	
}
