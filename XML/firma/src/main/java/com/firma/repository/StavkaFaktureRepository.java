package com.firma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firma.models.faktura.FakturaClass.StavkaClass;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaClass, Long> {

}
