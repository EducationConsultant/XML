package com.firma.services;

import java.util.List;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.NalogZaPrenosDTO;
import com.firma.models.nalogzaprenos.NalogZaPrenos;

public interface NalogZaPrenosDTOService {

	public NalogZaPrenosDTO findOne(Long id);

	public NalogZaPrenosDTO save(NalogZaPrenosDTO nalogZaPrenos);

	public List<NalogZaPrenosDTO> find();

	public NalogZaPrenos kreirajNalog(FakturaDTO faktura, NalogZaPrenosDTO nalog);

}
