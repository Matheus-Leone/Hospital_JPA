package com.example.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital.dto.PacienteRequestDTO;
import com.example.hospital.dto.PacienteResponseDTO;
import com.example.hospital.exception.RegraNegocioException;
import com.example.hospital.model.Paciente;
import com.example.hospital.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PacienteResponseDTO::new)
                .toList();
    }

    public PacienteResponseDTO buscarPorId(Long id) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        return new PacienteResponseDTO(paciente);
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {

        Paciente paciente = new Paciente();

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());

        Paciente pacienteSalvo = repository.save(paciente);

        return new PacienteResponseDTO(pacienteSalvo);
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {

        Paciente pacienteExistente = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        pacienteExistente.setNome(dto.getNome());
        pacienteExistente.setCpf(dto.getCpf());
        pacienteExistente.setTelefone(dto.getTelefone());

        Paciente pacienteAtualizado = repository.save(pacienteExistente);

        return new PacienteResponseDTO(pacienteAtualizado);
    }

    public boolean deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Paciente não encontrado");
        }

        repository.deleteById(id);

        return true;
    }
}