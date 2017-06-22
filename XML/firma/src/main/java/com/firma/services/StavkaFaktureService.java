package com.firma.services;

import java.util.List;


import com.firma.models.domain.StavkaDTO;

public interface StavkaFaktureService {
	public StavkaDTO save(StavkaDTO stavka);

	public StavkaDTO findOne(Long id);

	public List<StavkaDTO> find();
}
