package com.example.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital.dto.ProntuarioRequestDTO;
import com.example.hospital.dto.ProntuarioResponseDTO;
import com.example.hospital.exception.RegraNegocioException;
import com.example.hospital.model.Paciente;
import com.example.hospital.model.Prontuario;
import com.example.hospital.repository.PacienteRepository;
import com.example.hospital.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;
    private final PacienteRepository pacienteRepository;

    public ProntuarioService(ProntuarioRepository repository, PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<ProntuarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProntuarioResponseDTO::new)
                .toList();
    }

    public ProntuarioResponseDTO buscarPorId(Long id) {

        Prontuario prontuario = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Prontuário não encontrado"));

        return new ProntuarioResponseDTO(prontuario);
    }

    public ProntuarioResponseDTO salvar(ProntuarioRequestDTO dto) {

        Prontuario prontuario = new Prontuario();

        prontuario.setTipoSanguineo(dto.getTipoSanguineo());
        prontuario.setAlergia(dto.getAlergia());
        prontuario.setObservacoes(dto.getObservacoes());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        prontuario.setPaciente(paciente);

        Prontuario prontuarioSalvo = repository.save(prontuario);

        return new ProntuarioResponseDTO(prontuarioSalvo);
    }

    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO dto) {

        Prontuario prontuarioExistente = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Prontuário não encontrado"));

        prontuarioExistente.setTipoSanguineo(dto.getTipoSanguineo());
        prontuarioExistente.setAlergia(dto.getAlergia());
        prontuarioExistente.setObservacoes(dto.getObservacoes());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        prontuarioExistente.setPaciente(paciente);

        Prontuario atualizado = repository.save(prontuarioExistente);

        return new ProntuarioResponseDTO(atualizado);
    }

    public boolean deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Prontuário não encontrado");
        }

        repository.deleteById(id);

        return true;
    }
}