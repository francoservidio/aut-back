package org.serviconsulting.aut.model;




import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USUARIOS_USR")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "USR_SEQ")
    @SequenceGenerator(name = "USR_SEQ", sequenceName = "USR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name="NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name= "ES_ADMIN")
    @Type(type = "numeric_boolean")
    private Boolean esAdmin;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private Date fechaUltimaModificacion;




    public Usuarios() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return Objects.equals(id, usuarios.id);



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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }
}
