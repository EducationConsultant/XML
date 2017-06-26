package com.centralnaBanka.services;

import java.util.List;

import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.domain.CentralnaBanka;

public interface CentralnaBankaService {

	public CentralnaBanka save(CentralnaBanka cb);

	public CentralnaBanka findOne(Long id);
	
	public List<Banka> findBanke(Long id);

	public List<CentralnaBanka> find();

	public CentralnaBanka findByNaziv(String naziv);
}
