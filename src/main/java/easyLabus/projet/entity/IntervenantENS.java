package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class IntervenantENS {
    @Id
    @GeneratedValue
    @Column(name = "idintervenant")
    private Long idintervenant;

    @Basic
    @Column(name = "idFicheENS",insertable = false,updatable = false)
    private Long idFicheENS;

    @ManyToOne
    @JoinColumn (name="idFicheENS", referencedColumnName ="idFicheENS",nullable=false )
    private FicheENS ficheENS;

    @Basic
    @Column(name = "prenompers", nullable = false)
    private String prenompers;
    @Basic
    @Column(name = "nompers", nullable = false)
    private String nompers;
    @Basic
    @Column(name = "numtel", nullable = true)
    private String numtel;
    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    @Basic
    @Column(name="coordprivee", nullable = false)
    private Boolean coordprivee = true;

    public IntervenantENS(FicheENS ficheENS, Personneinterne pers) {
        this.ficheENS = ficheENS;
        this.idFicheENS = ficheENS.getIdFicheENS();
        this.prenompers = pers.getPrenompers();
        this.nompers = pers.getNompers();
        this.numtel = pers.getNumtel();
        this.email = pers.getEmail();
        this.coordprivee = pers.getCoordPrivee();
    }
}
