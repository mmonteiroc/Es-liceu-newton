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
@Table(name = "usuari")
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idusuari")
    private Integer idusuari;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nom")
    private String nom;

    @Column(name = "cognoms")
    private String cognoms;

    @OneToMany(mappedBy = "usuari", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Observacion> comentariosObservaciones;

    public Usuari() {
    }

    public Integer getIdusuari() {
        return idusuari;
    }

    public void setIdusuari(Integer idusuari) {
        this.idusuari = idusuari;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public List<Observacion> getComentariosObservaciones() {
        return comentariosObservaciones;
    }

    public void setComentariosObservaciones(List<Observacion> observaciones) {
        this.comentariosObservaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuari usuari = (Usuari) o;
        return Objects.equals(idusuari, usuari.idusuari) &&
                Objects.equals(username, usuari.username) &&
                Objects.equals(password, usuari.password) &&
                Objects.equals(nom, usuari.nom) &&
                Objects.equals(cognoms, usuari.cognoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuari, username, password, nom, cognoms, comentariosObservaciones);
    }
}
