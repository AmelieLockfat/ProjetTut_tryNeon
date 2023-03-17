package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class FicheUE {
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
    @Column(name = "responsableue", nullable = false)
    private String responsableue;

    @Basic
    @Column(name = "intervenants", nullable = false)
    private ArrayList<String> intervenants = new ArrayList<String>();

    @Basic
    @Column(name = "intitulediplome", nullable = false)
    private String intitulediplome;

    @Basic
    @Column(name = "nomorientation", nullable = false)
    private String nomorientation;

    @Basic
    @Column(name = "intituleniveau", nullable = false)
    private String intituleniveau;

    @Basic
    @Column(name = "numsemestre", nullable = false)
    private Integer numsemestre;

    @Basic
    @Column(name = "enseignements", nullable = false)
    private HashMap<String,String> enseignements = new HashMap<String,String>();

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

    @Basic
    @Column(name = "anneedetude", nullable = false)
    private String anneedetude;

    public FicheUE(Ue ue) {
        this.codeue = ue.getCodeue();
        this.intituleue = ue.getIntituleue();
        this.creditsects = ue.getCreditsects();
        this.heurecm = ue.getHeurecm();
        this.heuretd = ue.getHeuretd();
        this.heuretp = ue.getHeuretp();
        this.volumtravailperso = ue.getVolumtravailperso();
        this.volumprojet = ue.getVolumprojet();
        this.volumstage = ue.getVolumstage();
        this.modalitescontrole = ue.getModalitescontrole();
        this.prerequis = ue.getPrerequis();
        this.bibliographiedebase = ue.getBibliographiedebase();
        this.ordreue = ue.getOrdreue();
        this.motcles = ue.getMotcles();
        this.competenses = ue.getCompetenses();
        for (Enseignement ens : ue.getEnseignements()){
            enseignements.put(ens.getNomens(), ens.getContenu());
            for (Personneinterne pers : ens.getPersonnesinternes()){
                intervenants.add(pers.getPrenompers()+" "+pers.getNompers());
            }
        }
        Semestre sem = ue.getSemestre();
        this.numsemestre = sem.getNumsemestre();
        Niveau niv = sem.getNiveau();
        this.intituleniveau = niv.getIntituleniveau();
        Orientation ori = niv.getOrientation();
        this.nomorientation = ori.getNomorientation();
        this.intitulediplome = ori.getDiplome().getIntitulediplome();
        //this.anneedetude = 
    }
}
