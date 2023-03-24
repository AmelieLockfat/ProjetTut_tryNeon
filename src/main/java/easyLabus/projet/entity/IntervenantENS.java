package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity
public class IntervenantENS {
    @Id
    @GeneratedValue
    @Column(name = "idintervenant",insertable=false, updatable=false)
    private Long idintervenant;

    @Basic
    @Column(name = "idFicheENS",insertable=false,updatable = false)
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

    public IntervenantENS(Long idFicheENS, Personneinterne pers) {
        this.idFicheENS = idFicheENS;
        this.prenompers = pers.getPrenompers();
        this.nompers = pers.getNompers();
        this.numtel = pers.getNumtel();
        this.email = pers.getEmail();
        this.coordprivee = pers.getCoordprivee();
    }
}
