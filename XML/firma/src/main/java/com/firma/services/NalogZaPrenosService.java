package com.firma.services;

import java.util.List;

import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;

public interface NalogZaPrenosService {

	public NalogZaPrenosIzvedeno findOne(Long id);
	public NalogZaPrenosIzvedeno save(NalogZaPrenosIzvedeno nalogZaPrenos);
	public List<NalogZaPrenosIzvedeno> find();
	
}
