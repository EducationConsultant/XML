package com.firma.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.faktura.Faktura;
import com.firma.repository.FakturaRepository;
import com.firma.repository.FirmaRepository;
import com.firma.services.FirmaService;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService {

	@Autowired
	private FirmaRepository repository;
	
	@Autowired
	private FakturaRepository fakturaRepository;

	List<FakturaDTO> fakture = new ArrayList<FakturaDTO>();
	
	
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

	@Override
	public Firma saveFaktura(Long id, FakturaDTO faktura) {
		
		fakturaRepository.save(faktura);
		Firma firma = repository.findOne(id);
		fakture = firma.getFakture();
		fakture.add(faktura);
		firma.setFakture(fakture);
		repository.save(firma);
	
		
		return firma;
	}

	@Override
	public Firma sendFaktura(Long id1, Long id2, FakturaDTO faktura) {

		fakturaRepository.save(faktura);
		Firma firma = repository.findOne(id2);
		fakture.clear();
		fakture = firma.getFakture();
		fakture.add(faktura);
		firma.setFakture(fakture);
		repository.save(firma);
		

		return firma;
	}

}
