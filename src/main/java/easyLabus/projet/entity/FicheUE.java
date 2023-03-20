package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class FicheUE {
    @Id
    @GeneratedValue
    @Column(name = "idficheUE")
    private Long idFicheUE;

    @Column(name = "codeue")
    private String codeue;
    @Basic
    @Column(name = "intituleue", nullable = false)
    private String intituleue;
    @Basic
    @Column(name = "creditsects", nullable = false)
    private Integer creditsects;

    @Basic
    @Column(name = "responsableue", nullable = false)
    private String responsableue;

    @OneToMany(mappedBy = "ficheUE")
    private ArrayList<IntervenantUE> intervenants = new ArrayList<IntervenantUE>();

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

    @OneToMany(mappedBy = "ficheUE")
    private ArrayList<Contenu> contenus = new ArrayList<Contenu>();

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
        Semestre sem = ue.getSemestre();
        this.numsemestre = sem.getNumsemestre();
        Niveau niv = sem.getNiveau();
        this.intituleniveau = niv.getIntituleniveau();
        Orientation ori = niv.getOrientation();
        this.nomorientation = ori.getNomorientation();
        this.intitulediplome = ori.getDiplome().getIntitulediplome();
        //this.anneedetude = 
    }

    public Long getIdFicheUE (){
        return idFicheUE;
    }

    public ArrayList<Contenu> getContenus (){
        return contenus;
    }

    public void setContenus (ArrayList<Contenu> contenus){
        this.contenus = contenus;
    }

    public void addContenu (Contenu contenu){
        contenus.add(contenu);
    }

    public void delContenu (Contenu contenu){
        contenus.remove(contenu);
    }

    public ArrayList<IntervenantUE> getIntervenants (){
        return intervenants;
    }

    public void setIntervenants (ArrayList<IntervenantUE> intervenants){
        this.intervenants = intervenants;
    }

    public void addIntervenant (IntervenantUE intervenant){
        intervenants.add(intervenant);
    }

    public void delIntervenant (IntervenantUE intervenant){
        intervenants.remove(intervenant);
    }
}
