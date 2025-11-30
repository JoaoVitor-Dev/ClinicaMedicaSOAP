package org.joaovitor.modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Consulta {
    private Integer id;
    private Medico medico;
    private Paciente paciente;

    @XmlJavaTypeAdapter(AdaptadorDate.class)
    private Date data;
    private String descricao;

    public Consulta() {}

    public Consulta(Integer id, Medico medico, Paciente paciente, Date data, String descricao) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
