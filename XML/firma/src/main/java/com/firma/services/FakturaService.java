package com.firma.services;

import java.util.List;

import com.firma.models.faktura.FakturaClass;
import com.firma.models.faktura.FakturaClass.StavkaClass;

public interface FakturaService {
	public FakturaClass save(FakturaClass faktura);

	public FakturaClass findOne(Long id);

	public List<FakturaClass> find();

	public FakturaClass saveStavka(Long id, StavkaClass stavka);
}
