package org.joaovitor.autenticacao;

import org.joaovitor.excecoes.UsuarioNaoAutorizado;
import org.joaovitor.modelo.Usuario;

public class Autenticador {

    static final String LOGIN = "admin";
    static final String SENHA = "123";

    public static void validar(Usuario usuario) throws UsuarioNaoAutorizado {
        if (usuario == null ||
                !LOGIN.equals(usuario.getLogin()) ||
                !SENHA.equals(usuario.getSenha())) {
            throw new UsuarioNaoAutorizado("Usuário não autorizado");
        }
    }
}
