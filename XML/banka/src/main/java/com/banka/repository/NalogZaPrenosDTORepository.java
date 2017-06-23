package com.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banka.models.domain.NalogZaPrenosDTO;

@Repository
public interface NalogZaPrenosDTORepository extends JpaRepository<NalogZaPrenosDTO, Long> {

}
