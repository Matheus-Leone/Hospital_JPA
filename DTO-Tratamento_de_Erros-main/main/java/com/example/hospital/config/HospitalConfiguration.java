package com.example.hospital.config;

import com.example.hospital.model.Consulta;
import com.example.hospital.model.Convenio;
import com.example.hospital.model.Medico;
import com.example.hospital.model.Paciente;
import com.example.hospital.model.Prontuario;
import com.example.hospital.model.Receita;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HospitalConfiguration {

    @Bean
    public Prontuario prontuarioBean() {
        Prontuario prontuario = new Prontuario();

        prontuario.setId(1L);
        prontuario.setTipoSanguineo("O+");
        prontuario.setAlergia("Dipirona");
        prontuario.setObservacoes("Paciente com histórico de medicamentos fortes.");

        return prontuario;
    }

    @Bean
    public Medico medicoBean() {
        Medico medico = new Medico();

        medico.setId(1L);
        medico.setNome("Dra. Maria Eduarda");
        medico.setEspecialidade("Clínica Geral");
        medico.setCrm("CRM-SP 123456");

        return medico;
    }

    @Bean
    public Convenio convenioBean() {
        Convenio convenio = new Convenio();

        convenio.setId(1L);
        convenio.setNome("SUS");
        convenio.setCnpj("12.345.678/0001-99");

        return convenio;
    }

    @Bean
    public Receita receitaBean() {
        Receita receita = new Receita();

        receita.setId(1L);
        receita.setMedicamento("Amoxicilina");
        receita.setDosagem("500mg");
        receita.setDuracaoDias(7);

        return receita;
    }

    @Bean
    public Consulta consultaBean(Medico medicoBean, Convenio convenioBean, Receita receitaBean) {
        Consulta consulta = new Consulta();

        consulta.setDataHora(LocalDateTime.now());
        consulta.setMotivo("Consulta de Rotina");
        consulta.setValor(150.0);
        consulta.setMedico(medicoBean);
        consulta.setConvenio(convenioBean);
        consulta.setReceita(receitaBean);

        return consulta;
    }

    @Bean
    public Paciente pacienteBean(Prontuario prontuarioBean, Consulta consultaBean) {
        Paciente paciente = new Paciente();

        paciente.setId(1L);
        paciente.setNome("Fernando de Oliveira");
        paciente.setCpf("123.456.789-00");
        paciente.setTelefone("(15) 99999-9999");
        paciente.setProntuario(prontuarioBean);

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consultaBean);

        paciente.setConsultas(consultas);

        consultaBean.setPaciente(paciente);

        return paciente;
    }
}