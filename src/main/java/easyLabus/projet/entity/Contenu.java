package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity
public class Contenu {
    @Id
    @GeneratedValue
    @Column(name = "idcontenu")
    private Long idcontenu;

    @Basic
    @Column(name = "idFicheUE",updatable = false)
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

    public Contenu(Long idFicheUE, Enseignement enseignement) {
        this.idFicheUE = idFicheUE;
        this.nomens = enseignement.getNomens();
        this.contenu = enseignement.getContenu();
    }
}
