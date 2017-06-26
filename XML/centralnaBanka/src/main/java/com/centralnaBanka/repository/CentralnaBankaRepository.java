package com.centralnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.centralnaBanka.models.domain.CentralnaBanka;

@Repository
public interface CentralnaBankaRepository extends JpaRepository<CentralnaBanka, Long> {

	public CentralnaBanka findByNaziv(String naziv);
}

