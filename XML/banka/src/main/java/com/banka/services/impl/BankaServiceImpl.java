package com.banka.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banka.models.domain.Banka;
import com.banka.repository.BankaRepository;
import com.banka.services.BankaService;

public class BankaServiceImpl implements BankaService {

	@Autowired
	private BankaRepository repository;

	@Override
	public Banka save(Banka banka) {
		return repository.save(banka);
	}

	@Override
	public Banka findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Banka> find() {
		return repository.findAll();
	}

	@Override
	public Banka findByNaziv(String naziv) {
		return repository.findByNaziv(naziv);
	}

}
