package org.zetaconsulting.eyetracking.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "RED_PRIVADA_REP")
public class RedesPrivada implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "RED_SEQ")
    @SequenceGenerator(name = "RED_SEQ", sequenceName = "RED_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE_VLAN")
    private String nombreVlan;

    @Column(name = "TAG_VLAN")
    private String tagVlan;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "SUBMASK")
    private String submask;

    @Column(name = "IP_HELPER")
    private String ipHelper;

    public RedesPrivada() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedesPrivada redesPrivada = (RedesPrivada) o;
        return Objects.equals(id, redesPrivada.id);

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

    public String getNombreVlan() {
        return nombreVlan;
    }

    public void setNombreVlan(String nombreVlan) {
        this.nombreVlan = nombreVlan;
    }

    public String getTagVlan() {
        return tagVlan;
    }

    public void setTagVlan(String tagVlan) {
        this.tagVlan = tagVlan;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubmask() {
        return submask;
    }

    public void setSubmask(String submask) {
        this.submask = submask;
    }

    public String getIpHelper() {
        return ipHelper;
    }

    public void setIpHelper(String ipHelper) {
        this.ipHelper = ipHelper;
    }
}
