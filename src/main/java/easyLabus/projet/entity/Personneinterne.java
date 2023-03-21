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
    @Column(name = "intituleniveau", insertable = false,updatable = false, nullable = true)
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
    private List<Enseignement> enseignements;

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom) {
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
        this.prenompers = prenom;
        this.nompers = nom;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String intituleniveau) {
        this(identifiant, motdepasse, prenom, nom);
        this.intituleniveau = intituleniveau;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String intituleniveau, String email) {
        this(identifiant, motdepasse, prenom, nom, intituleniveau);
        this.email = email;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom, String intituleniveau, String email, String numtel) {
        this(identifiant, motdepasse, prenom, intituleniveau, nom, email);
        this.numtel = numtel;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom,String intituleniveau, String email, String numtel, Boolean coordprivee) {
        this(identifiant, motdepasse, prenom, nom, intituleniveau, email, numtel);
        this.coordprivee = coordprivee;
    }

    public Personneinterne(String identifiant, String motdepasse, String prenom, String nom,String intituleniveau, String email, String numtel, Boolean coordprivee, Boolean estdirecteur) {
        this(identifiant, motdepasse, prenom, nom, intituleniveau, email, numtel, coordprivee);
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

    public boolean getCoordprivee() {
        return coordprivee;
    }

    public void modifCoordprivee() {
        this.coordprivee = !coordprivee;
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

    public void setIntituleniveau(String intituleniveau) {
        this.intituleniveau = intituleniveau;
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

    public List<Enseignement> getEnseignements() {
        return enseignements;
    }

    public boolean equals (Personneinterne pers){
        return this.identifiant.equals(pers.getIdentifiant());
    }
}
