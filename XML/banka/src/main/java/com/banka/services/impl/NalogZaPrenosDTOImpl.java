package com.banka.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banka.models.domain.NalogZaPrenosDTO;
import com.banka.repository.NalogZaPrenosDTORepository;
import com.banka.services.NalogZaPrenosDTOService;

@Service
@Transactional
public class NalogZaPrenosDTOImpl implements NalogZaPrenosDTOService {

	@Autowired
	private NalogZaPrenosDTORepository repository;

	@Override
	public NalogZaPrenosDTO findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public NalogZaPrenosDTO save(NalogZaPrenosDTO nalogZaPrenos) {
		return repository.save(nalogZaPrenos);
	}

	@Override
	public List<NalogZaPrenosDTO> find() {
		return repository.findAll();
	}

}
