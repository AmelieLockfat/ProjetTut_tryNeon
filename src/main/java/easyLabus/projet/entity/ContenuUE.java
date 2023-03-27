package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity
public class ContenuUE {
    @Id
    @GeneratedValue
    @Column(name = "idcontenu",insertable=false, updatable=false)
    private Long idcontenu;

    @Basic
    @Column(name = "idFicheUE",insertable=false, updatable = false)
    private Long idFicheUE;

    @ManyToOne
    @JoinColumn (name="idFicheUE", referencedColumnName ="idFicheUE",nullable=false )
    private FicheUE ficheUE;

    @Basic
    @Column(name = "nomens",insertable = false, nullable = false)
    private String nomens;
    @Basic
    @Column(name = "contenu", insertable = false,nullable = false)
    private String contenu;

    public ContenuUE(Long idFicheUE, Enseignement enseignement) {
        this.idFicheUE = idFicheUE;
        this.nomens = enseignement.getNomens();

    }

    public ContenuUE() {

    }
}
