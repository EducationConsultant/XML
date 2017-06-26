package com.centralnaBanka.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.domain.CentralnaBanka;
import com.centralnaBanka.repository.CentralnaBankaRepository;
import com.centralnaBanka.services.CentralnaBankaService;

@Service
@Transactional
public class CentralnaBankaImpl implements CentralnaBankaService {

	@Autowired
	private CentralnaBankaRepository repository;
	
	@Override
	public CentralnaBanka save(CentralnaBanka cb) {
		return repository.save(cb);
	}

	@Override
	public CentralnaBanka findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<CentralnaBanka> find() {
		return repository.findAll();
	}

	@Override
	public CentralnaBanka findByNaziv(String naziv) {
		return repository.findByNaziv(naziv);
	}

	@Override
	public List<Banka> findBanke(Long id) {
		CentralnaBanka cb = repository.findOne(id);
		List<Banka> banke = cb.getBanke();
		return banke;
	}

}
