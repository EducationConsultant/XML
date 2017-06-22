package com.firma.services;

import java.util.List;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaDTO.StavkaClass;

public interface FakturaService {
	public FakturaDTO save(FakturaDTO faktura);

	public FakturaDTO findOne(Long id);

	public List<FakturaDTO> find();

	public FakturaDTO saveStavka(Long id, StavkaClass stavka);
}
