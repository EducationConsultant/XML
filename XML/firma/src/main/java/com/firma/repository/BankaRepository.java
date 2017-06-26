package com.firma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.domain.Banka;

@Repository
public interface BankaRepository extends JpaRepository<Banka, Long> {
	public Banka findByNaziv(String naziv);
}
