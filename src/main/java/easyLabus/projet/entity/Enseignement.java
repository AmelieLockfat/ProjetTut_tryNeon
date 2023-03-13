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

   // @OneToMany(mappedBy = "Enseignementbycodeens")
    //private List<Enseigner> Personnesinternesbyenseignement;

@ManyToMany(mappedBy = "Enseignementsss")
private List<Personneinterne> Personnesinternes;


    @ManyToOne
    @JoinColumn (name ="codeue", referencedColumnName = "codeue",nullable = false)
    private Ue Uebycodeue;

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

    public String getCodeens() {
        return codeens;
    }

    public void setCodeens(String codeens) {
        this.codeens = codeens;
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
    }

    public Double getHeuretd() {
        return heuretd;
    }

    public void setHeuretd(Double heuretd) {
        this.heuretd = heuretd;
    }

    public Double getHeuretp() {
        return heuretp;
    }

    public void setHeuretp(Double heuretp) {
        this.heuretp = heuretp;
    }

    public Double getHeuretotalencadree() {
        return heuretotalencadree;
    }

    public void setHeuretotalencadree(Double heuretotalencadree) {
        this.heuretotalencadree = heuretotalencadree;
    }

    public String getCodeue() {
        return codeue;
    }

    public void setCodeue(String codeue) {
        this.codeue = codeue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enseignement that = (Enseignement) o;

        if (codeens != null ? !codeens.equals(that.codeens) : that.codeens != null) return false;
        if (nomens != null ? !nomens.equals(that.nomens) : that.nomens != null) return false;
        if (heurecm != null ? !heurecm.equals(that.heurecm) : that.heurecm != null) return false;
        if (heuretd != null ? !heuretd.equals(that.heuretd) : that.heuretd != null) return false;
        if (heuretp != null ? !heuretp.equals(that.heuretp) : that.heuretp != null) return false;
        if (heuretotalencadree != null ? !heuretotalencadree.equals(that.heuretotalencadree) : that.heuretotalencadree != null)
            return false;
        if (codeue != null ? !codeue.equals(that.codeue) : that.codeue != null) return false;
        if (heuretravailperso != null ? !heuretravailperso.equals(that.heuretravailperso) : that.heuretravailperso != null)
            return false;
        if (coefficient != null ? !coefficient.equals(that.coefficient) : that.coefficient != null) return false;
        if (modalitesevaluation != null ? !modalitesevaluation.equals(that.modalitesevaluation) : that.modalitesevaluation != null)
            return false;
        if (prerequis != null ? !prerequis.equals(that.prerequis) : that.prerequis != null) return false;
        if (planducours != null ? !planducours.equals(that.planducours) : that.planducours != null) return false;
        if (contenu != null ? !contenu.equals(that.contenu) : that.contenu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeens != null ? codeens.hashCode() : 0;
        result = 31 * result + (nomens != null ? nomens.hashCode() : 0);
        result = 31 * result + (heurecm != null ? heurecm.hashCode() : 0);
        result = 31 * result + (heuretd != null ? heuretd.hashCode() : 0);
        result = 31 * result + (heuretp != null ? heuretp.hashCode() : 0);
        result = 31 * result + (heuretotalencadree != null ? heuretotalencadree.hashCode() : 0);
        result = 31 * result + (codeue != null ? codeue.hashCode() : 0);
        result = 31 * result + (heuretravailperso != null ? heuretravailperso.hashCode() : 0);
        result = 31 * result + (coefficient != null ? coefficient.hashCode() : 0);
        result = 31 * result + (modalitesevaluation != null ? modalitesevaluation.hashCode() : 0);
        result = 31 * result + (prerequis != null ? prerequis.hashCode() : 0);
        result = 31 * result + (planducours != null ? planducours.hashCode() : 0);
        result = 31 * result + (contenu != null ? contenu.hashCode() : 0);
        return result;
    }
}
