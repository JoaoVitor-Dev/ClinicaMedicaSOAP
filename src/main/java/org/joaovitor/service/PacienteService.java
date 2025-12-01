package org.joaovitor.service;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.joaovitor.autenticacao.Autenticador;
import org.joaovitor.dao.PacienteDAO;
import org.joaovitor.excecoes.UsuarioNaoAutorizado;
import org.joaovitor.modelo.Paciente;
import org.joaovitor.modelo.Usuario;

@WebService
public class PacienteService {

    private PacienteDAO dao = new PacienteDAO();

    @WebResult(name = "paciente")
    public java.util.List<Paciente> obterTodosPacientes() {
        return dao.obterTodos();
    }

    @WebResult(name = "paciente")
    public java.util.List<Paciente> obterPacientePorCpf(
            @WebParam(name = "CPF") String cpf) {
        return dao.obterPorCPF(cpf);
    }

    public void cadastrarPaciente(
            @WebParam(name = "paciente") Paciente paciente,
            @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizado {

        Autenticador.validar(usuario);

        dao.adicionar(paciente);
    }
}
