package org.joaovitor.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.joaovitor.autenticacao.Autenticador;
import org.joaovitor.dao.ConsultaDAO;
import org.joaovitor.dao.MedicoDAO;
import org.joaovitor.dao.PacienteDAO;
import org.joaovitor.excecoes.MedicoNaoEncontradoException;
import org.joaovitor.excecoes.PacienteNaoEncontradoException;
import org.joaovitor.excecoes.UsuarioNaoAutorizado;
import org.joaovitor.modelo.Consulta;
import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Paciente;
import org.joaovitor.modelo.Usuario;

import java.util.Date;
import java.util.List;

@WebService
public class ConsultaService {

    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    @WebMethod
    public List<Consulta> obterTodasAsConsultas() {
        return consultaDAO.obterTodas();
    }

    @WebMethod
    public List<Consulta> obterConsultasPorMedico(@WebParam(name="idMedico") Integer idMedico) {
        return consultaDAO.obterPorMedico(idMedico);
    }

    @WebMethod
    public String cadastrarConsulta(
            @WebParam(name="idMedico") Integer idMedico,
            @WebParam(name="idPaciente") Integer idPaciente,
            @WebParam(name="descricao") String descricao,
            @WebParam(name="usuario", header = true) Usuario usuario
    ) throws  UsuarioNaoAutorizado,
    MedicoNaoEncontradoException,
    PacienteNaoEncontradoException {

        Autenticador.validar(usuario);

        Medico m = medicoDAO.obterMedico(idMedico);

        if (m == null) {
            throw new MedicoNaoEncontradoException(idMedico);
        }

        Paciente p = pacienteDAO.obterPaciente(idPaciente);

        if (p == null) {
            throw new PacienteNaoEncontradoException(idPaciente);
        }

        Consulta c = new Consulta(
                (int)(Math.random() * 1000),
                m,
                p,
                new Date(),
                descricao
        );

        consultaDAO.adicionar(c);

        return "Consulta inserida com sucesso!";
    }
}
