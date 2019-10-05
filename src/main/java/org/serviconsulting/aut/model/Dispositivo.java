package org.serviconsulting.aut.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DISPOSITIVO_DIS")
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "DIS_SEQ")
    @SequenceGenerator(name = "DIS_SEQ", sequenceName = "DIS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "HOSTNAME")
    private String hostname;

    @Column(name = "IP")
    private String ip;

    @Column(name = "TEMPLATE")
    private String template;

    @Column(name = "DESCRIPTION")
    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private Date fechaDate;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private Date fechaUltimaModificacion;

    public Dispositivo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo dispositivo = (Dispositivo) o;
        return Objects.equals(id, dispositivo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDate() {
        return fechaDate;
    }

    public void setFechaDate(Date fechaDate) {
        this.fechaDate = fechaDate;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }
}
