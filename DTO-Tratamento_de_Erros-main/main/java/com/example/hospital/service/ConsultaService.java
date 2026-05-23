package com.example.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital.dto.ConsultaRequestDTO;
import com.example.hospital.dto.ConsultaResponseDTO;
import com.example.hospital.exception.RegraNegocioException;
import com.example.hospital.model.Consulta;
import com.example.hospital.model.Convenio;
import com.example.hospital.model.Medico;
import com.example.hospital.model.Paciente;
import com.example.hospital.repository.ConsultaRepository;
import com.example.hospital.repository.ConvenioRepository;
import com.example.hospital.repository.MedicoRepository;
import com.example.hospital.repository.PacienteRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    private final ConvenioRepository convenioRepository;

    public ConsultaService(
            ConsultaRepository repository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository,
            ConvenioRepository convenioRepository
    ) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.convenioRepository = convenioRepository;
    }

    public List<ConsultaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ConsultaResponseDTO::new)
                .toList();
    }

    public ConsultaResponseDTO buscarPorId(Long id) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Consulta não encontrada"));

        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() ->
                        new RegraNegocioException("Médico não encontrado"));

        Convenio convenio = convenioRepository.findById(dto.getConvenioId())
                .orElseThrow(() ->
                        new RegraNegocioException("Convênio não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setConvenio(convenio);

        Consulta salva = repository.save(consulta);

        return new ConsultaResponseDTO(salva);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {

        Consulta consultaExistente = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Consulta não encontrada"));

        consultaExistente.setDataHora(dto.getDataHora());
        consultaExistente.setMotivo(dto.getMotivo());
        consultaExistente.setValor(dto.getValor());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() ->
                        new RegraNegocioException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() ->
                        new RegraNegocioException("Médico não encontrado"));

        Convenio convenio = convenioRepository.findById(dto.getConvenioId())
                .orElseThrow(() ->
                        new RegraNegocioException("Convênio não encontrado"));

        consultaExistente.setPaciente(paciente);
        consultaExistente.setMedico(medico);
        consultaExistente.setConvenio(convenio);

        Consulta atualizada = repository.save(consultaExistente);

        return new ConsultaResponseDTO(atualizada);
    }

    public boolean deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Consulta não encontrada");
        }

        repository.deleteById(id);

        return true;
    }
}