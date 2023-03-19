package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Niveau {
    @Id
    @Column(name = "intituleniveau")
    private String intituleniveau;
    @Basic
    @Column(name = "nomorientation",insertable = false,updatable = false)
    private String nomorientation;

    @ManyToOne
    @JoinColumn (name="nomorientation", referencedColumnName ="nomorientation",nullable=false )
    private Orientation orientation;


    @OneToMany(mappedBy = "niveau")
    private List<Semestre> semestres = new ArrayList<>();

    public Niveau(String intituleniveau, Orientation orientation) {
        this.intituleniveau = intituleniveau;
        this.orientation = orientation;
        this.nomorientation = orientation.getNomorientation();
    }

    public String getIntituleniveau() {
        return intituleniveau;
    }

    public void setIntituleniveau(String intituleniveau) {
        this.intituleniveau = intituleniveau;
    }

    public String getNomorientation() {
        return nomorientation;
    }
    
    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        this.nomorientation = orientation.getNomorientation();
    }
}
