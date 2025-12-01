package org.joaovitor.dao;

import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDAO {

    private static List<Paciente> pacientes = new ArrayList<>();

    static {
        pacientes.add(new Paciente(1, "Ana Paula", "03723786090"));
        pacientes.add(new Paciente(2, "Lucas Ferreira", "64139490071"));
        pacientes.add(new Paciente(3, "Beatriz Ramos", "98759961066"));
    }

    public List<Paciente> obterTodos() {
        return pacientes;
    }

    public List<Paciente> obterPorCPF(String cpf) {
        return pacientes.stream()
                .filter(p -> p.getCpf() == cpf)
                .collect(Collectors.toList());
    }

    public Paciente obterPaciente(int codigo) {
            return pacientes.stream()
                    .filter(paciente -> paciente.getId() == codigo)
                    .findFirst()
                    .orElse(null);
    }

    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }
}
