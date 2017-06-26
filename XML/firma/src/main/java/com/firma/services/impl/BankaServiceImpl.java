package com.firma.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firma.models.domain.Banka;
import com.firma.repository.BankaRepository;
import com.firma.services.BankaService;

@Service
@Transactional
public class BankaServiceImpl implements BankaService {

	@Autowired
	private BankaRepository bankaRepository;

	@Override
	public Banka save(Banka banka) {
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
