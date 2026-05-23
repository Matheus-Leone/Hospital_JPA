package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}