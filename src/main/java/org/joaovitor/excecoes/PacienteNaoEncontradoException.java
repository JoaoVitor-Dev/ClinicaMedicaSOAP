package org.joaovitor.excecoes;

public class PacienteNaoEncontradoException extends Exception {
    public PacienteNaoEncontradoException(Integer id) {
        super("Paciente com ID " + id + " não foi encontrado.");
    }
}
