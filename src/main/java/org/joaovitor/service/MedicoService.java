package org.joaovitor.service;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.joaovitor.autenticacao.Autenticador;
import org.joaovitor.dao.MedicoDAO;
import org.joaovitor.excecoes.UsuarioNaoAutorizado;
import org.joaovitor.modelo.Medico;
import org.joaovitor.modelo.Usuario;

@WebService
public class MedicoService {
    private MedicoDAO dao = new MedicoDAO();

    @WebResult(name = "medico")
    public java.util.List<Medico> obterTodos() {
        return dao.obterTodos();
    }

    @WebResult(name = "medico")
    public java.util.List<Medico> obterPorEspecialidade(
            @WebParam(name = "especialidade") String esp) {
        return dao.obterPorEspecialidade(esp);
    }

    public void adicionarMedico(
            @WebParam(name = "medico") Medico medico,
            @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizado {

        Autenticador.validar(usuario);

        dao.adicionar(medico);
    }
}
