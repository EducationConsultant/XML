//package com.firma.services.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.firma.models.faktura.Faktura;
//import com.firma.models.faktura.Zaglavlje;
//import com.firma.repository.FakturaRepository;
//import com.firma.services.FakturaService;
//
//@Service
//@Transactional
//public class FakturaServiceImpl implements FakturaService {
//
//	@Autowired
//	private FakturaRepository repository;
//
//	@Override
//	public Faktura save(Faktura faktura) {
//		return repository.save(faktura);
//	}
//
//	@Override
//	public Faktura findByZaglavlje(Zaglavlje zaglavlje) {
//		return repository.findByZaglavlje(zaglavlje);
//	}
//
//	@Override
//	public List<Faktura> find() {
//		return repository.findAll();
//	}
//
//}
