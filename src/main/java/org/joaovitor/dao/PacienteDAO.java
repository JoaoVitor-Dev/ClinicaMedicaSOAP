package org.joaovitor.dao;

import org.joaovitor.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDAO {

    private static List<Paciente> pacientes = new ArrayList<>();

    static {
        pacientes.add(new Paciente(1, "Ana Paula", ""));
        pacientes.add(new Paciente(2, "Lucas Ferreira", ""));
        pacientes.add(new Paciente(3, "Beatriz Ramos", ""));
    }

    public List<Paciente> listar() {
        return pacientes;
    }

    public List<Paciente> listarPacientePorCPF(String cpf) {
        return pacientes.stream()
                .filter(p -> p.getCpf() == cpf)
                .collect(Collectors.toList());
    }

    public void inserir(Paciente paciente) {
        pacientes.add(paciente);
    }
}
