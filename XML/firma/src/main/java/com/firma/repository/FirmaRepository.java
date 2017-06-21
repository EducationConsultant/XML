package com.firma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.entities.Firma;

@Repository
public interface FirmaRepository extends JpaRepository<Firma,Long> {


	public Firma findByNaziv(String naziv);

}
