package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity
public class IntervenantUE {
    @Id
    @GeneratedValue
    @Column(name = "idintervenant")
    private Long idintervenant;

    @Basic
    @Column(name = "idFicheUE",updatable = false)
    private Long idFicheUE;

    @ManyToOne
    @JoinColumn (name="idFicheUE", referencedColumnName ="idFicheUE",nullable=false )
    private FicheUE ficheUE;

    @Basic
    @Column(name = "prenompers", nullable = false)
    private String prenompers;
    @Basic
    @Column(name = "nompers", nullable = false)
    private String nompers;

    public IntervenantUE(Long idFicheUE, Personneinterne pers) {
        this.idFicheUE = idFicheUE;
        this.prenompers = pers.getPrenompers();
        this.nompers = pers.getNompers();
    }
}
