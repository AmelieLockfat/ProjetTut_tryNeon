package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ue {

    @Id
    @Column(name = "codeue")
    private  String codeue;
    @Basic
    @Column(name = "intituleue")
    private String intituleue;
    @Basic
    @Column(name = "creditsects")
    private Integer creditsects;
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
    @Column(name = "volumtravailperso")
    private Double volumtravailperso;
    @Basic
    @Column(name = "volumprojet")
    private Double volumprojet;

    @Basic
    @Column(name = "idsemestre",insertable = false,updatable = false)
    private Integer idsemestre;

    @ManyToOne
    @JoinColumn (name="idsemestre", referencedColumnName ="idsemestre",nullable=false )
    private Semestre semestre;

    @OneToMany(mappedBy = "Uebycodeue")
    private List<Enseignement> Enseignementbyue = new ArrayList<>();

    @Basic
    @Column(name = "modalitescontrole")
    private String modalitescontrole;
    @Basic
    @Column(name = "prerequis")
    private String prerequis;
    @Basic
    @Column(name = "bibliographiedebase")
    private String bibliographiedebase;
    @Basic
    @Column(name = "ordreue")
    private Integer ordreue;
    @Basic
    @Column(name = "motcles")
    private String motcles;
    @Basic
    @Column(name = "competenses")
    private String competenses;

    public  String getCodeue() {
        return codeue;
    }

    public void setCodeue(String codeue) {
        this.codeue = codeue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ue ue = (Ue) o;

        if (codeue != null ? !codeue.equals(ue.codeue) : ue.codeue != null) return false;
        if (intituleue != null ? !intituleue.equals(ue.intituleue) : ue.intituleue != null) return false;
        if (creditsects != null ? !creditsects.equals(ue.creditsects) : ue.creditsects != null) return false;
        if (heurecm != null ? !heurecm.equals(ue.heurecm) : ue.heurecm != null) return false;
        if (heuretd != null ? !heuretd.equals(ue.heuretd) : ue.heuretd != null) return false;
        if (heuretp != null ? !heuretp.equals(ue.heuretp) : ue.heuretp != null) return false;
        if (volumtravailperso != null ? !volumtravailperso.equals(ue.volumtravailperso) : ue.volumtravailperso != null)
            return false;
        if (volumprojet != null ? !volumprojet.equals(ue.volumprojet) : ue.volumprojet != null) return false;
        return false;
    }

    @Override
    public int hashCode() {
        int result = codeue != null ? codeue.hashCode() : 0;
        result = 31 * result + (intituleue != null ? intituleue.hashCode() : 0);
        result = 31 * result + (creditsects != null ? creditsects.hashCode() : 0);
        result = 31 * result + (heurecm != null ? heurecm.hashCode() : 0);
        result = 31 * result + (heuretd != null ? heuretd.hashCode() : 0);
        result = 31 * result + (heuretp != null ? heuretp.hashCode() : 0);
        result = 31 * result + (volumtravailperso != null ? volumtravailperso.hashCode() : 0);
        result = 31 * result + (volumprojet != null ? volumprojet.hashCode() : 0);
        result = 31 * result + (idsemestre != null ? idsemestre.hashCode() : 0);
        result = 31 * result + (modalitescontrole != null ? modalitescontrole.hashCode() : 0);
        result = 31 * result + (prerequis != null ? prerequis.hashCode() : 0);
        result = 31 * result + (bibliographiedebase != null ? bibliographiedebase.hashCode() : 0);
        result = 31 * result + (ordreue != null ? ordreue.hashCode() : 0);
        result = 31 * result + (motcles != null ? motcles.hashCode() : 0);
        result = 31 * result + (competenses != null ? competenses.hashCode() : 0);
        return result;
    }
}
