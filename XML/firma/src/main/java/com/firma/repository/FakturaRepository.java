package com.firma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.domain.FakturaDTO;

@Repository
public interface FakturaRepository extends JpaRepository<FakturaDTO, Long> {

}
