package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
}