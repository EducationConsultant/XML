package com.firma.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.firma.models.entities.Firma;
import com.firma.repository.FirmaRepository;
import com.firma.services.FirmaService;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService{

	@Autowired
	private FirmaRepository repository;
	
	
	@Override
	public Firma findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Firma save(Firma firma) {
		return repository.save(firma);
	}

	@Override
	public Firma findByNaziv(String naziv) {
		return repository.findByNaziv(naziv);
	}

	@Override
	public List<Firma> find() {
		return repository.findAll();
	}

}
