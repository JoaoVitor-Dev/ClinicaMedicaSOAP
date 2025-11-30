package org.joaovitor.dao;

import org.joaovitor.modelo.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicoDAO {

    private static List<Medico> medicos = new ArrayList<>();

    static {
        medicos.add(new Medico(1, "Dr. João Silva", "", "Cardiologia"));
        medicos.add(new Medico(2, "Dra. Maria Lima", "", "Dermatologia"));
        medicos.add(new Medico(3, "Dr. Carlos Souza", "", "Ortopedia"));
    }

    public List<Medico> listar() {
        return medicos;
    }

    public List<Medico> listarPorEspecialidade(String esp) {
        return medicos.stream()
                .filter(m -> m.getEspecialidade().equalsIgnoreCase(esp))
                .collect(Collectors.toList());
    }

    public void inserir(Medico medico) {
        medicos.add(medico);
    }
}
