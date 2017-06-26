package com.banka.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banka.models.domain.Firma;

import com.banka.repository.FirmaRepository;

import com.banka.services.FirmaService;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService {

	@Autowired
	private FirmaRepository firmaRepository;

	@Override
	public Firma save(Firma firma) {
		return firmaRepository.save(firma);
	}

	@Override
	public Firma findOne(Long id) {
		return firmaRepository.findOne(id);
	}

	@Override
	public List<Firma> find() {
		return firmaRepository.findAll();
	}

	@Override
	public Firma findByNaziv(String naziv) {
		return firmaRepository.findByNaziv(naziv);
	}

}