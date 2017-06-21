package com.firma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;

@Repository
public interface NalogZaPrenosRepository extends JpaRepository<NalogZaPrenosIzvedeno, Long> {

}
