package com.firma.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firma.models.faktura.FakturaClass;
import com.firma.models.faktura.FakturaClass.StavkaClass;
import com.firma.repository.FakturaRepository;
import com.firma.repository.StavkaFaktureRepository;
import com.firma.services.FakturaService;

@Service
@Transactional
public class FakturaServiceImpl implements FakturaService {

	@Autowired
	private FakturaRepository fakturaRepository;

	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;

	@Override
	public FakturaClass save(FakturaClass faktura) {
		return fakturaRepository.save(faktura);
	}

	@Override
	public List<FakturaClass> find() {
		return fakturaRepository.findAll();
	}

	@Override
	public FakturaClass findOne(Long id) {
		return fakturaRepository.findOne(id);
	}

	@Override
	public FakturaClass saveStavka(Long id, StavkaClass stavka) {
		stavkaFaktureRepository.save(stavka);
		FakturaClass faktura = this.findOne(id);
		List<StavkaClass> stavke = new ArrayList<StavkaClass>();
		stavke.add(stavka);
		faktura.setStavka(stavke);

		return faktura;
	}

}
