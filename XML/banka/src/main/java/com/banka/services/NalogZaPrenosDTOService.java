package com.banka.services;

import java.util.List;

import com.banka.models.domain.NalogZaPrenosDTO;

public interface NalogZaPrenosDTOService {

	public NalogZaPrenosDTO findOne(Long id);

	public NalogZaPrenosDTO save(NalogZaPrenosDTO nalogZaPrenos);

	public List<NalogZaPrenosDTO> find();

}
