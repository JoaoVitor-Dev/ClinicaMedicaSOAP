package org.joaovitor.dao;

import org.joaovitor.modelo.Consulta;
import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaDAO {

    private static List<Consulta> consultas = new ArrayList<>();

    static {
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();

        List<Medico> medicos = medicoDAO.obterTodos();
        List<Paciente> pacientes = pacienteDAO.obterTodos();

        if (!medicos.isEmpty() && !pacientes.isEmpty()) {
            consultas.add(new Consulta(
                    1,
                    medicos.get(0),
                    pacientes.get(0),
                    new Date(),
                    "Consulta de rotina"
            ));

            if (medicos.size() > 1 && pacientes.size() > 1) {
                consultas.add(new Consulta(
                        2,
                        medicos.get(1),
                        pacientes.get(1),
                        new Date(),
                        "Acompanhamento dermatológico"
                ));
            }

            if (medicos.size() > 2 && pacientes.size() > 2) {
                consultas.add(new Consulta(
                        3,
                        medicos.get(2),
                        pacientes.get(2),
                        new Date(),
                        "Retorno ortopédico"
                ));
            }
        }
    }

    public List<Consulta> obterTodas() {
        return consultas;
    }

    public List<Consulta> obterPorMedico(Integer idMedico) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().getId().equals(idMedico)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public void adicionar(Consulta consulta) {
        consultas.add(consulta);
    }
}
