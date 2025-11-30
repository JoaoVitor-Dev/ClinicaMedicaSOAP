package org.joaovitor.excecoes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.ws.WebFault;

import java.util.Date;

@WebFault(
        targetNamespace = "http://service.joaovitor.org/excecoes/",
        name = "UsuarioNaoAutorizado")
public class UsuarioNaoAutorizado extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoAutorizado() {}

    public UsuarioNaoAutorizado(String message) { super(message); }

    public UsuarioNaoAutorizado(Throwable cause) { super(cause); }

    public UsuarioNaoAutorizado(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNaoAutorizado(String message, Throwable cause,
                                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsuarioFaultInfo getFaultInfo() {
        return new UsuarioFaultInfo(getMessage());
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class UsuarioFaultInfo {

        @XmlAttribute
        private String mensagem;

        private Date data;

        public UsuarioFaultInfo(String mensagem) {
            this.mensagem = mensagem;
            this.data = new Date();
        }

        public UsuarioFaultInfo() {}

        public Date getData() {
            return data;
        }
    }
}
