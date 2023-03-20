package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class FicheENS {
    @Id
    @GeneratedValue
    @Column(name = "idficheENS")
    private Long idficheENS;

    @Basic
    @Column(name = "codeens")
    private String codeens;

    @Basic
    @Column(name = "nomens", nullable = false)
    private String nomens;

    @Basic
    @Column(name = "heurecm", nullable = false)
    private Double heurecm;
    @Basic
    @Column(name = "heuretd", nullable = false)
    private Double heuretd;
    @Basic
    @Column(name = "heuretp", nullable = false)
    private Double heuretp;
    @Basic
    @Column(name = "heuretotalencadree", nullable = false)
    private Double heuretotalencadree;

    @OneToMany(mappedBy = "ficheENS")
    private ArrayList<IntervenantENS> intervenants = new ArrayList<IntervenantENS>();

    @Basic
    @Column(name = "codeue", nullable = false)
    private String codeue;
    @Basic
    @Column(name = "intituleue", insertable = false, nullable = false)
    private String intituleue;
    @Basic
    @Column(name = "numsemestre", insertable = false, nullable = false)
    private int numsemestre;

    @Basic
    @Column(name = "anneedetude", nullable = false)
    private String anneedetude;

    @Basic
    @Column(name = "heuretravailperso", nullable = true)
    private Double heuretravailperso;
    @Basic
    @Column(name = "coefficient", nullable = true)
    private Double coefficient;
    @Basic
    @Column(name = "prerequis", nullable = true)
    private String prerequis;
    @Basic
    @Column(name = "planducours", nullable = true)
    private String planducours;
    @Basic
    @Column(name = "modalitesevaluation", nullable = true)
    private String modalitesevaluation;

    public FicheENS (Enseignement enseignement){
        this.codeens = enseignement.getCodeens();
        this.nomens = enseignement.getNomens();
        this.heurecm = enseignement.getHeurecm();
        this.heuretd = enseignement.getHeuretd();
        this.heuretp = enseignement.getHeuretp();
        this.heuretotalencadree = enseignement.getHeuretotalencadree();
        this.heuretravailperso = enseignement.getHeuretravailperso();
        this.coefficient = enseignement.getCoefficient();
        this.prerequis = enseignement.getPrerequis();
        this.planducours = enseignement.getPlanducours();
        this.modalitesevaluation = enseignement.getModalitesevaluation();
        Ue ue = enseignement.getUe();
        this.codeue = ue.getCodeue();
        this.intituleue = ue.getIntituleue();
        this.numsemestre = ue.getSemestre().getNumsemestre();
        //this.anneedetude = ???????????????????
    }

    public Long getIdFicheENS (){
        return idficheENS;
    }

    public ArrayList<IntervenantENS> getIntervenants(){
        return intervenants;
    }

    public void setIntervenants(ArrayList<IntervenantENS> intervenants){
        this.intervenants = intervenants;
    }

    public void addIntervenant(IntervenantENS intervenant){
        intervenants.add(intervenant);
    }

    public void delIntervenant(IntervenantENS intervenant){
        intervenants.remove(intervenant);
    }
}
