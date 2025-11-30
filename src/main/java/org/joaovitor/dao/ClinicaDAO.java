package org.joaovitor.dao;

import org.joaovitor.modelo.Consulta;
import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClinicaDAO {
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();

    static {
        Medico m1 = new Medico(1, "Dr. João", "12345", "Cardiologia");
        Medico m2 = new Medico(2, "Dra. Ana", "56789", "Dermatologia");

        Paciente p1 = new Paciente(1, "Carlos Silva", "111.222.333-44");
        Paciente p2 = new Paciente(2, "Maria Souza", "555.666.777-88");

        medicos.add(m1);
        medicos.add(m2);
        pacientes.add(p1);
        pacientes.add(p2);

        consultas.add(new Consulta(1, m1, p1, new Date(), "Consulta de rotina"));
        consultas.add(new Consulta(2, m2, p2, new Date(), "Acompanhamento dermatológico"));
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Consulta> filtrarConsultasPorMedico(Integer idMedico) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().getId().equals(idMedico)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public void inserirConsulta(Consulta consulta) {
        consultas.add(consulta);
    }
}
