package com.firma.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;
import com.firma.repository.NalogZaPrenosRepository;
import com.firma.services.NalogZaPrenosService;

@Service
@Transactional
public class NalogZaPrenosImpl implements NalogZaPrenosService {

	@Autowired
	private NalogZaPrenosRepository repository;

	@Override
	public NalogZaPrenosIzvedeno findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public NalogZaPrenosIzvedeno save(NalogZaPrenosIzvedeno nalogZaPrenos) {
		return repository.save(nalogZaPrenos);
	}

	@Override
	public List<NalogZaPrenosIzvedeno> find() {
		return repository.findAll();
	}

}
