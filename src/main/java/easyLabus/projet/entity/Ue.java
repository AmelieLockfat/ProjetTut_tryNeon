package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Ue {

    @Id
    @Column(name = "codeue")
    private  String codeue;
    @Basic
    @Column(name = "intituleue", nullable = false)
    private String intituleue;
    @Basic
    @Column(name = "creditsects", nullable = false)
    private Integer creditsects;
    @Basic
    @Column(name = "heurecm", insertable = false, nullable = false)
    private Double heurecm;
    @Basic
    @Column(name = "heuretd", insertable = false, nullable = false)
    private Double heuretd;
    @Basic
    @Column(name = "heuretp", insertable = false, nullable = false)
    private Double heuretp;
    @Basic
    @Column(name = "volumtravailperso", nullable = true)
    private Double volumtravailperso;
    @Basic
    @Column(name = "volumprojet", nullable = true)
    private Double volumprojet;
    @Basic
    @Column(name = "volumstage", nullable = true)
    private Double volumstage;

    @Basic
    @Column(name = "idsemestre",insertable = false,updatable = false)
    private Integer idsemestre;

    @ManyToOne
    @JoinColumn (name="idsemestre", referencedColumnName ="idsemestre",nullable=false )
    private Semestre semestre;

    @OneToMany(mappedBy = "ue")
    private ArrayList<Enseignement> enseignements = new ArrayList<>();

    @Basic
    @Column(name = "modalitescontrole", nullable = true)
    private String modalitescontrole;
    @Basic
    @Column(name = "prerequis", nullable = true)
    private String prerequis;
    @Basic
    @Column(name = "bibliographiedebase", nullable = true)
    private String bibliographiedebase;
    @Basic
    @Column(name = "ordreue", nullable = true)
    private Integer ordreue;
    @Basic
    @Column(name = "motcles", nullable = true)
    private String motcles;
    @Basic
    @Column(name = "competenses", nullable = true)
    private String competenses;

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects) {
        this.codeue = codeue;
        this.intituleue = intituleue;
        this.semestre = semestre;
        this.idsemestre = semestre.getIdsemestre();
        this.creditsects = creditsects;
        this.heurecm = 0.0;
        this.heuretd = 0.0;
        this.heuretp = 0.0;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso) {
        this(codeue, intituleue, semestre, creditsects);
        this.volumtravailperso = volumtravailperso;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso);
        this.volumprojet = volumprojet;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet);
        this.volumstage = volumstage;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage);
        this.modalitescontrole = modalitescontrole;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole);
        this.prerequis = prerequis;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis);
        this.bibliographiedebase = bibliographiedebase;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase);
        this.ordreue = ordreue;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue, String motcles) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase, ordreue);
        this.motcles = motcles;
    }

    public Ue(String codeue, String intituleue, Semestre semestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue, String motcles, String competenses) {
        this(codeue, intituleue, semestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase, ordreue, motcles);
        this.competenses = competenses;
    }

    public  String getCodeue() {
        return codeue;
    }

    public String getIntituleue() {
        return intituleue;
    }

    public void setIntituleue(String intituleue) {
        this.intituleue = intituleue;
    }

    public Integer getCreditsects() {
        return creditsects;
    }

    public void setCreditsects(Integer creditsects) {
        this.creditsects = creditsects;
    }

    public Double getHeurecm() {
        return heurecm;
    }

    public Double getHeuretd() {
        return heuretd;
    }

    public Double getHeuretp() {
        return heuretp;
    }

    public Double getVolumtravailperso() {
        return volumtravailperso;
    }

    public void setVolumtravailperso(Double volumtravailperso) {
        this.volumtravailperso = volumtravailperso;
    }

    public Double getVolumprojet() {
        return volumprojet;
    }

    public void setVolumprojet(Double volumprojet) {
        this.volumprojet = volumprojet;
    }

    public Double getVolumstage() {
        return volumstage;
    }

    public void setVolumstage(Double volumstage) {
        this.volumstage = volumstage;
    }

    public Integer getIdsemestre() {
        return idsemestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
        this.idsemestre = semestre.getIdsemestre();
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public String getModalitescontrole() {
        return modalitescontrole;
    }

    public void setModalitescontrole(String modalitescontrole) {
        this.modalitescontrole = modalitescontrole;
    }

    public String getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(String prerequis) {
        this.prerequis = prerequis;
    }

    public String getBibliographiedebase() {
        return bibliographiedebase;
    }

    public void setBibliographiedebase(String bibliographiedebase) {
        this.bibliographiedebase = bibliographiedebase;
    }

    public Integer getOrdreue() {
        return ordreue;
    }

    public void setOrdreue(Integer ordreue) {
        this.ordreue = ordreue;
    }

    public String getMotcles() {
        return motcles;
    }

    public void setMotcles(String motcles) {
        this.motcles = motcles;
    }

    public String getCompetenses() {
        return competenses;
    }

    public void setCompetenses(String competenses) {
        this.competenses = competenses;
    }

    public void addEnseignement(Enseignement enseignement) {
        enseignements.add(enseignement);
        heurecm += enseignement.getHeurecm();
        heuretd += enseignement.getHeuretd();
        heuretp += enseignement.getHeuretp();
    }

    public void delEnseignement(Enseignement enseignement) {
        enseignements.remove(enseignement);
        heurecm -= enseignement.getHeurecm();
        heuretd -= enseignement.getHeuretd();
        heuretp -= enseignement.getHeuretp();
    }

    public ArrayList<Enseignement> getEnseignements() {
        return enseignements;
    }

    public void setEnseignements(ArrayList<Enseignement> enseignements) {
        this.enseignements = enseignements;
        heurecm = 0.0;
        heuretd = 0.0;
        heuretp = 0.0;
        for (Enseignement ens:enseignements) {
            heurecm += ens.getHeurecm();
            heuretd += ens.getHeuretd();
            heuretp += ens.getHeuretp();
        }
    }

    public boolean equals(Ue ue) {
        return this.codeue.equals(ue.getCodeue());
    }
}
