package org.joaovitor.excecoes;

public class MedicoNaoEncontradoException extends Exception {
    public MedicoNaoEncontradoException(Integer id) {
        super("Médico com ID " + id + " não foi encontrado.");
    }
}
