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
    @Column(name = "nomorientation",insertable = false, updatable = false)
    private String nomorientation;

    @ManyToOne
    @JoinColumn (name="nomorientation", referencedColumnName ="nomorientation",nullable=false )
    private Orientation orientation;


    @OneToMany(mappedBy = "niveau", cascade=CascadeType.REMOVE)
    private List<Semestre> semestres = new ArrayList<>();

    public Niveau(String intituleniveau, String nomorientation) {
        this.intituleniveau = intituleniveau;
        this.nomorientation = nomorientation;
    }

    public Niveau() {

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

    public void setNomorientation(String nomorientation) {
        this.nomorientation = nomorientation;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public boolean equals(Niveau niveau) {
        return this.intituleniveau.equals(niveau.getIntituleniveau());
    }
}
