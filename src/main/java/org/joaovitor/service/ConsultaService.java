package org.joaovitor.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.joaovitor.autenticacao.Autenticador;
import org.joaovitor.dao.ClinicaDAO;
import org.joaovitor.excecoes.UsuarioNaoAutorizado;
import org.joaovitor.modelo.Consulta;
import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Paciente;
import org.joaovitor.modelo.Usuario;

import java.util.Date;
import java.util.List;

@WebService
public class ConsultaService {

    private ClinicaDAO dao  = new ClinicaDAO();

    @WebMethod
    public List<Consulta> listarConsultas() {
        return dao.obterTodas();
    }

    @WebMethod
    public List<Consulta> filtrarConsultasPorMedico(@WebParam(name="idMedico") Integer idMedico) {
        return dao.obterPorMedico(idMedico);
    }

    @WebMethod
    public String inserirConsulta(
            @WebParam(name="idMedico") Integer idMedico,
            @WebParam(name="idPaciente") Integer idPaciente,
            @WebParam(name="descricao") String descricao,
            @WebParam(name="usuario", header = true) Usuario usuario
    ) throws UsuarioNaoAutorizado {

        Autenticador.validar(usuario);

        Medico m = new Medico(idMedico, "Medico fake", "0000", "geral");
        Paciente p = new Paciente(idPaciente, "Paciente fake", "000.000.000-00");

        Consulta c = new Consulta(
                (int)(Math.random() * 1000),
                m,
                p,
                new Date(),
                descricao
        );

        dao.adicionar(c);

        return "Consulta inserida com sucesso!";
    }
}
