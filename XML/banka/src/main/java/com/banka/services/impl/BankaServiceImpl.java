package com.banka.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banka.models.domain.Banka;
import com.banka.models.domain.Firma;
import com.banka.repository.BankaRepository;
import com.banka.repository.FirmaRepository;
import com.banka.services.BankaService;

@Service
@Transactional
public class BankaServiceImpl implements BankaService {

	@Autowired
	private BankaRepository bankaRepository;

	@Autowired
	private FirmaRepository firmaRepository;

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

	@Override
	public Banka saveFirma(Long id, Firma firma) {
		Banka banka = this.findOne(id);

		List<Firma> firme = banka.getFirme();
		firma.setBanka(banka);

		firmaRepository.save(firma);
		firme.add(firma);

		banka.setFirme(firme);

		return banka;
	}

}
