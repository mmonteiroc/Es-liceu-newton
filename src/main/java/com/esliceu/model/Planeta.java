package com.esliceu.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.model
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Entity
@Table(name = "planeta")
public class Planeta {

    @Id
    @GeneratedValue()
    @Column(name = "idplaneta")
    private Integer idplaneta;

    @Column(name = "nom")
    private String nom;

    @Column(name = "massa")
    private Long massa;

    @Column(name = "habitable")
    private boolean habitable;

    @OneToMany(mappedBy = "planeta", orphanRemoval = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Satelite> satelites;

    @OneToMany(mappedBy = "planetaUsuariPlanetas", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Observacion> observaciones;


    public Planeta() {

    }

    public Integer getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(Integer idplaneta) {
        this.idplaneta = idplaneta;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getMassa() {
        return massa;
    }

    public void setMassa(Long massa) {
        this.massa = massa;
    }

    public boolean isHabitable() {
        return habitable;
    }

    public void setHabitable(boolean habitable) {
        this.habitable = habitable;
    }

    public List<Satelite> getSatelites() {
        return satelites;
    }

    public void setSatelites(List<Satelite> satelites) {
        this.satelites = satelites;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "idplaneta=" + idplaneta +
                ", nom='" + nom + '\'' +
                ", massa=" + massa +
                ", habitable=" + habitable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planeta planeta = (Planeta) o;
        return habitable == planeta.habitable &&
                Objects.equals(idplaneta, planeta.idplaneta) &&
                Objects.equals(nom, planeta.nom) &&
                Objects.equals(massa, planeta.massa) &&
                Objects.equals(satelites, planeta.satelites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idplaneta, nom, massa, habitable, satelites, observaciones);
    }
}