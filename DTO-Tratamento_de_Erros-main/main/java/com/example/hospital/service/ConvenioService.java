package com.example.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital.dto.ConvenioRequestDTO;
import com.example.hospital.dto.ConvenioResponseDTO;
import com.example.hospital.exception.RegraNegocioException;
import com.example.hospital.model.Convenio;
import com.example.hospital.repository.ConvenioRepository;

@Service
public class ConvenioService {

    private final ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    public List<ConvenioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ConvenioResponseDTO::new)
                .toList();
    }

    public ConvenioResponseDTO buscarPorId(Long id) {

        Convenio convenio = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Convênio não encontrado"));

        return new ConvenioResponseDTO(convenio);
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO dto) {

        Convenio convenio = new Convenio();

        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());

        Convenio convenioSalvo = repository.save(convenio);

        return new ConvenioResponseDTO(convenioSalvo);
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto) {

        Convenio convenioExistente = repository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Convênio não encontrado"));

        convenioExistente.setNome(dto.getNome());
        convenioExistente.setCnpj(dto.getCnpj());

        Convenio convenioAtualizado = repository.save(convenioExistente);

        return new ConvenioResponseDTO(convenioAtualizado);
    }

    public boolean deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RegraNegocioException("Convênio não encontrado");
        }

        repository.deleteById(id);

        return true;
    }
}