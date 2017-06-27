package com.firma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;

@Repository
public interface FakturaRepository extends JpaRepository<FakturaDTO, Long> {
	public List<FakturaDTO> findByFirma(Firma firma);
}
