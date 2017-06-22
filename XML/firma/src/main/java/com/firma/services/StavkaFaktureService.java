package com.firma.services;

import java.util.List;

import com.firma.models.domain.FakturaDTO.StavkaClass;

public interface StavkaFaktureService {
	public StavkaClass save(StavkaClass stavka);

	public StavkaClass findOne(Long id);

	public List<StavkaClass> find();
}
