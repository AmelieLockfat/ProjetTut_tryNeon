package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Personneinterne {

    @Id
    @Column(name = "identifiant")
    private String identifiant;
    @Basic
    @Column(name = "motdepasse", nullable = false)
    private String motdepasse;
    @Basic
    @Column(name = "prenompers", nullable = false)
    private String prenompers;
    @Basic
    @Column(name = "nompers", nullable = false)
    private String nompers;
    @Basic
    @Column(name = "estdirecteur", nullable = false)
    private Boolean estdirecteur = false;

    @Basic
    @Column(name = "intituleniveau", insertable = false, nullable = true)
    private String intituleniveau;
    
    @ManyToOne
    @JoinColumn (name="intituleniveau", referencedColumnName ="intituleniveau",nullable=true)
    private Niveau niveau;

    @Basic
    @Column(name="coordprivee", nullable = false)
    private Boolean coordprivee = true;

    @Basic
    @Column(name = "numtel", nullable = true)
    private String numtel;
    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    @ManyToMany
    @JoinTable(name="Enseigner", joinColumns = @JoinColumn(name="identifiant",referencedColumnName = "identifiant"),inverseJoinColumns = @JoinColumn(name="codeens",referencedColumnName = "codeens"))
    private ArrayList<Enseignement> enseignementsss;

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom) {
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
        this.prenompers = prenom;
        this.nompers = nom;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, Niveau niveau) {
        this(identifiant, motdepasse, prenom, nom);
        this.niveau = niveau;
        this.intituleniveau = niveau.getIntituleniveau();
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String email) {
        this(identifiant, motdepasse, prenom, nom);
        this.email = email;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel) {
        this(identifiant, motdepasse, prenom, nom, email);
        this.numtel = numtel;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, Niveau niveau) {
        this(identifiant, motdepasse, prenom, nom, email, numtel);
        this.niveau = niveau;
        this.intituleniveau = niveau.getIntituleniveau();
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, Niveau niveau, Boolean coordprivee) {
        this(identifiant, motdepasse, prenom, nom, email, numtel, niveau);
        this.coordprivee = coordprivee;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, Niveau niveau, Boolean coordprivee, Boolean estdirecteur) {
        this(identifiant, motdepasse, prenom, nom, email, numtel, niveau, coordprivee);
        this.estdirecteur = estdirecteur;
    }

    public Personneinterne() {

    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getPrenompers() {
        return prenompers;
    }

    public void setPrenompers(String prenompers) {
        this.prenompers = prenompers;
    }

    public String getNompers() {
        return nompers;
    }

    public void setNompers(String nompers) {
        this.nompers = nompers;
    }

    public Boolean getEstdirecteur() {
        return estdirecteur;
    }

    public void modifEstdirecteur() {
        this.estdirecteur = !estdirecteur;
    }

    public String getIntituleniveau() {
        return intituleniveau;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
        this.intituleniveau = niveau.getIntituleniveau();
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getCoordPrivee() {
        return coordprivee;
    }

    public void modifCoordPrivee() {
        this.coordprivee = !coordprivee;
    }

    public ArrayList<Enseignement> getEnseignementsss() {
        return enseignementsss;
    }

    public void setEnseignementsss(ArrayList<Enseignement> enseignementsss) {
        this.enseignementsss = enseignementsss;
    }

    public void addEnseignement(Enseignement enseignement) {
        enseignementsss.add(enseignement);
    }

    public void delEnseignement(Enseignement enseignement) {
        enseignementsss.remove(enseignement);
    }

    public boolean equals(Personneinterne personneinterne) {
        return this.identifiant.equals(personneinterne.getIdentifiant());
    }
}
