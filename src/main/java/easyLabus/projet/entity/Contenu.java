package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Contenu {
    @Id
    @GeneratedValue
    @Column(name = "idcontenu")
    private Long idcontenu;

    @Basic
    @Column(name = "idFicheUE",insertable = false,updatable = false)
    private Long idFicheUE;

    @ManyToOne
    @JoinColumn (name="idFicheUE", referencedColumnName ="idFicheUE",nullable=false )
    private FicheUE ficheUE;

    @Basic
    @Column(name = "nomens", nullable = false)
    private String nomens;
    @Basic
    @Column(name = "contenu", nullable = false)
    private String contenu;

    public Contenu(FicheUE ficheUE, Enseignement enseignement) {
        this.ficheUE = ficheUE;
        this.idFicheUE = ficheUE.getIdFicheUE();
        this.nomens = enseignement.getNomens();
        this.contenu = enseignement.getContenu();
    }
}
