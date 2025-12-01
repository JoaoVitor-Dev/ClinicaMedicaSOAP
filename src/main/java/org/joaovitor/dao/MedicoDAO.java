package org.joaovitor.dao;

import org.joaovitor.modelo.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicoDAO {

    private static List<Medico> medicos = new ArrayList<>();

    static {
        medicos.add(new Medico(1, "Dr. João Silva", "23146", "Cardiologia"));
        medicos.add(new Medico(2, "Dra. Maria Lima", "27220", "Dermatologia"));
        medicos.add(new Medico(3, "Dr. Carlos Souza", "426712", "Ortopedia"));
    }

    public List<Medico> obterTodos() {
        return medicos;
    }

    public List<Medico> obterPorEspecialidade(String esp) {
        return medicos.stream()
                .filter(m -> m.getEspecialidade().equalsIgnoreCase(esp))
                .collect(Collectors.toList());
    }

    public Medico obterMedico(int codigo) {
        return medicos.stream()
                .filter(medico -> medico.getId() == codigo)
                .findFirst()
                .orElse(null);
    }

    public void adicionar(Medico medico) {
        medicos.add(medico);
    }
}
