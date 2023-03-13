package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Enseignement {
    @Id
    @Column(name = "codeens")
    private String codeens;
    @Basic
    @Column(name = "nomens")
    private String nomens;
    @Basic
    @Column(name = "heurecm")
    private Double heurecm;
    @Basic
    @Column(name = "heuretd")
    private Double heuretd;
    @Basic
    @Column(name = "heuretp")
    private Double heuretp;
    @Basic
    @Column(name = "heuretotalencadree")
    private Double heuretotalencadree;
    @Basic
    @Column(name = "codeue", insertable = false,updatable = false)
    private String codeue;

    @ManyToMany(mappedBy = "Enseignementsss")
    private ArrayList<Personneinterne> personnesinternes = new ArrayList<Personneinterne>();
    ;

    @ManyToOne
    @JoinColumn (name ="codeue", referencedColumnName = "codeue",nullable = false)
    private Ue ue;

    @Basic
    @Column(name = "heuretravailperso")
    private Double heuretravailperso;
    @Basic
    @Column(name = "coefficient")
    private Double coefficient;
    @Basic
    @Column(name = "modalitesevaluation")
    private String modalitesevaluation;
    @Basic
    @Column(name = "prerequis")
    private String prerequis;
    @Basic
    @Column(name = "planducours")
    private String planducours;
    @Basic
    @Column(name = "contenu")
    private String contenu;

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp){
        this.codeens = codeens;
        this.nomens = nomens;
        this.heurecm = heurecm;
        this.heuretd = heuretd;
        this.heuretp = heuretp;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
        this.ue = ue;
        this.codeue = ue.getCodeue();
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp);
        this.contenu = contenu;
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp, contenu);
        this.heuretravailperso = heuretravailperso;
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp, contenu, heuretravailperso);
        this.coefficient = coefficient;
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient);
        this.modalitesevaluation = modalitesevaluation;
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient, modalitesevaluation);
        this.prerequis = prerequis;
    }

    public Enseignement (String codeens, String nomens, Ue ue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis, String planducours){
        this(codeens, nomens, ue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient, modalitesevaluation, prerequis);
        this.planducours = planducours;
    }

    public String getCodeens() {
        return codeens;
    }

    public String getNomens() {
        return nomens;
    }

    public void setNomens(String nomens) {
        this.nomens = nomens;
    }

    public Double getHeurecm() {
        return heurecm;
    }

    public void setHeurecm(Double heurecm) {
        this.heurecm = heurecm;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretd() {
        return heuretd;
    }

    public void setHeuretd(Double heuretd) {
        this.heuretd = heuretd;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretp() {
        return heuretp;
    }

    public void setHeuretp(Double heuretp) {
        this.heuretp = heuretp;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretotalencadree() {
        return heuretotalencadree;
    }

    public String getCodeue() {
        return codeue;
    }

    public Double getHeuretravailperso() {
        return heuretravailperso;
    }

    public void setHeuretravailperso(Double heuretravailperso) {
        this.heuretravailperso = heuretravailperso;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getModalitesevaluation() {
        return modalitesevaluation;
    }

    public void setModalitesevaluation(String modalitesevaluation) {
        this.modalitesevaluation = modalitesevaluation;
    }

    public String getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(String prerequis) {
        this.prerequis = prerequis;
    }

    public String getPlanducours() {
        return planducours;
    }

    public void setPlanducours(String planducours) {
        this.planducours = planducours;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Ue getUe() {
        return ue;
    }

    public void setUe(Ue ue) {
        this.ue = ue;
        this.codeue = ue.getCodeue();
    }

    public ArrayList<Personneinterne> getPersonnesinternes() {
        return personnesinternes;
    }

    public void setPersonnesinternes(ArrayList<Personneinterne> personnesinternes) {
        this.personnesinternes = personnesinternes;
    }

    public void addPersonneinterne(Personneinterne personneinterne) {
        personnesinternes.add(personneinterne);
    }

    public void delPersonneinterne(Personneinterne personneinterne) {
        personnesinternes.remove(personneinterne);
    }
}
