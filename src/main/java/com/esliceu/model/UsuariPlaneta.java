package com.esliceu.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 29/01/2020
 * Package: com.esliceu.model
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Entity
@Table(name = "usuari_has_planeta")
public class UsuariPlaneta implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "usuari_idusuari", nullable = false)
    private Usuari usuari;

    @Id
    @ManyToOne
    @JoinColumn(name = "planeta_idplaneta", nullable = false)
    private Planeta planetaUsuariPlanetas;

    @Column(name = "observacions")
    private String comentario;


    @Override
    public String toString() {
        return "UsuariPlaneta{" +
                "usuari=" + usuari +
                ", planetaUsuariPlanetas=" + planetaUsuariPlanetas +
                ", comentario='" + comentario + '\'' +
                '}';
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Planeta getPlanetaUsuariPlanetas() {
        return planetaUsuariPlanetas;
    }

    public void setPlanetaUsuariPlanetas(Planeta planetaUsuariPlanetas) {
        this.planetaUsuariPlanetas = planetaUsuariPlanetas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariPlaneta that = (UsuariPlaneta) o;
        return Objects.equals(usuari, that.usuari) &&
                Objects.equals(planetaUsuariPlanetas, that.planetaUsuariPlanetas) &&
                Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuari, planetaUsuariPlanetas, comentario);
    }
}
