package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Orientation {

    @Id
    @Column(name = "nomorientation")
    private String nomorientation;
    @Basic
    @Column(name = "intitulediplome",insertable = false,updatable = false)
    private String intitulediplome;

    @ManyToOne
    @JoinColumn (name="intitulediplome", referencedColumnName ="intitulediplome",nullable=false )
    private Diplome diplome;

    @OneToMany(mappedBy = "orientation")
    private List<Niveau> niveaus = new ArrayList<>();

    public Orientation(String nomOrientation, String initulediplome) {
        this.nomorientation = nomOrientation;
        this.intitulediplome = initulediplome;
    }

    public Orientation() {

    }

    public String getNomorientation() {
        return nomorientation;
    }

    public void setNomorientation(String nomorientation) {
        this.nomorientation = nomorientation;
    }

    public String getIntitulediplome() {
        return intitulediplome;
    }
    
    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
        this.intitulediplome = diplome.getIntitulediplome();
    }

    public List<Niveau> getNiveaus() {
        return niveaus;
    }
/*
    public void setNiveaus(ArrayList<Niveau> niveaus) {
        this.niveaus = niveaus;
    }

    public void addNiveau(Niveau niveau) {
        niveaus.add(niveau);
    }

    public void delNiveau(Niveau niveau) {
        niveaus.remove(niveau);
    }

    public boolean equals(Orientation orientation) {
        return this.nomorientation.equals(orientation.getNomorientation());
    } */
}