package com.firma.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaDTO.StavkaClass;
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
	public FakturaDTO save(FakturaDTO faktura) {
		return fakturaRepository.save(faktura);
	}

	@Override
	public List<FakturaDTO> find() {
		return fakturaRepository.findAll();
	}

	@Override
	public FakturaDTO findOne(Long id) {
		return fakturaRepository.findOne(id);
	}

	@Override
	public FakturaDTO saveStavka(Long id, StavkaClass stavka) {
		stavkaFaktureRepository.save(stavka);
		FakturaDTO faktura = this.findOne(id);
		List<StavkaClass> stavke = new ArrayList<StavkaClass>();
		stavke.add(stavka);
		faktura.setStavka(stavke);

		return faktura;
	}

}
