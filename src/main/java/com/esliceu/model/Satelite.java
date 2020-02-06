package com.esliceu.model;


import javax.persistence.*;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.model
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Entity
@Table(name = "satelit")
public class Satelite {


    /*
     * GenerationType:
     *
     * IDENTITY -> autoincrement de la ultima id creada
     *
     * SEQUENCE -> tipo de seqüencia que quieres seguir en el autoincrement
     *
     * TABLE -> Tabla para generar identificadors
     *
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsatelit")
    private Integer idsatelit;

    @Column(name = "nom")
    private String nom;

    @Column(name = "massa")
    private Long massa;

    @Column(name = "velocitat")
    private Integer velocitat;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "planeta_idplaneta"), name = "planeta_idplaneta", nullable = true)
    private Planeta planeta;


    public Satelite() {
    }

    public Integer getIdsatelit() {
        return idsatelit;
    }

    public void setIdsatelit(Integer idsatelit) {
        this.idsatelit = idsatelit;
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

    public Integer getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(Integer velocitat) {
        this.velocitat = velocitat;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}
