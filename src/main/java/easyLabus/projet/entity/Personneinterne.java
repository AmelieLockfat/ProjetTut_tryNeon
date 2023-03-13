package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Personneinterne {

    @Id
    @Column(name = "identifiant")
    private String identifiant;
    @Basic
    @Column(name = "motdepasse")
    private String motdepasse;
    @Basic
    @Column(name = "prenompers")
    private String prenompers;
    @Basic
    @Column(name = "nompers")
    private String nompers;
    @Basic
    @Column(name = "estdirecteur")
    private Boolean estdirecteur;
    @Basic
    @Column(name = "intituleniveau",insertable = false,updatable = false)
    private String intituleniveau;

    @ManyToOne
    @JoinColumn (name="intituleniveau", referencedColumnName ="intituleniveau",nullable=true )
    private Niveau Niveaubyintituleniveau;

    @Basic
    @Column(name="coordprivee")
    private Boolean coordprivee;

    @Basic
    @Column(name = "numtel")
    private String numtel;
    @Basic
    @Column(name = "email")
    private String email;

//com
    //@OneToMany( mappedBy ="Personneinternebyidentifiant")
    //private List<Enseigner> Enseignementbyidentifiant = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="Enseigner", joinColumns = @JoinColumn(name="identifiant",referencedColumnName = "identifiant"),inverseJoinColumns = @JoinColumn(name="codeens",referencedColumnName = "codeens"))
    private List<Enseignement> Enseignementsss ;


    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
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

    public void setEstdirecteur(Boolean estdirecteur) {
        this.estdirecteur = estdirecteur;
    }

    public String getIntituleniveau() {
        return intituleniveau;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personneinterne that = (Personneinterne) o;

        if (identifiant != null ? !identifiant.equals(that.identifiant) : that.identifiant != null) return false;
        if (motdepasse != null ? !motdepasse.equals(that.motdepasse) : that.motdepasse != null) return false;
        if (prenompers != null ? !prenompers.equals(that.prenompers) : that.prenompers != null) return false;
        if (nompers != null ? !nompers.equals(that.nompers) : that.nompers != null) return false;
        if (estdirecteur != null ? !estdirecteur.equals(that.estdirecteur) : that.estdirecteur != null) return false;
        if (intituleniveau != null ? !intituleniveau.equals(that.intituleniveau) : that.intituleniveau != null)
            return false;
        if (numtel != null ? !numtel.equals(that.numtel) : that.numtel != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifiant != null ? identifiant.hashCode() : 0;
        result = 31 * result + (motdepasse != null ? motdepasse.hashCode() : 0);
        result = 31 * result + (prenompers != null ? prenompers.hashCode() : 0);
        result = 31 * result + (nompers != null ? nompers.hashCode() : 0);
        result = 31 * result + (estdirecteur != null ? estdirecteur.hashCode() : 0);
        result = 31 * result + (intituleniveau != null ? intituleniveau.hashCode() : 0);
        result = 31 * result + (numtel != null ? numtel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
