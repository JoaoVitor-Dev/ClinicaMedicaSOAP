package org.joaovitor;

import jakarta.xml.ws.Endpoint;
import org.joaovitor.service.ConsultaService;

public class Publicador {

    static final String PORTA = "8080";
    static final String URL_BASE = "http://localhost:"+PORTA;

    public static void main(String[] args) {

        System.out.println("Publicando serviços...");

        Endpoint.publish(URL_BASE +"/medico", new MedicoService());
        Endpoint.publish(URL_BASE +"/paciente", new PacienteService());
        Endpoint.publish(URL_BASE +"/consulta", new ConsultaService());

        System.out.println("WebService publicado e rodando na porta "+PORTA);
    }
}
