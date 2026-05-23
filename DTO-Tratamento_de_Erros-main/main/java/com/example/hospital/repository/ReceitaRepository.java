package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}