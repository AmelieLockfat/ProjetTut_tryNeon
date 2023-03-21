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
    @Column(name = "intitulediplome",updatable = false)
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

    public void setIntitulediplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }

    public List<Niveau> getNiveaus() {
        return niveaus;
    }
    
    public boolean equals(Orientation orientation) {
        return this.nomorientation.equals(orientation.getNomorientation());
    }
}