package com.centralnaBanka.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.domain.CentralnaBanka;
import com.centralnaBanka.repository.BankaRepository;
import com.centralnaBanka.repository.CentralnaBankaRepository;
import com.centralnaBanka.services.BankaService;

@Service
@Transactional
public class BankaServiceImpl implements BankaService {

	@Autowired
	private BankaRepository bankaRepository;
	
	@Autowired
	private CentralnaBankaRepository cbRepository;

	@Override
	public Banka save(Long idC, Banka banka) {
		CentralnaBanka cb = cbRepository.findOne(idC);
		banka.setCentralnaBanka(cb);
		cb.getBanke().add(banka);
		cbRepository.save(cb);
		return bankaRepository.save(banka);
	}

	@Override
	public Banka findOne(Long id) {
		return bankaRepository.findOne(id);
	}

	@Override
	public List<Banka> find() {
		return bankaRepository.findAll();
	}

	@Override
	public Banka findByNaziv(String naziv) {
		return bankaRepository.findByNaziv(naziv);
	}

}
