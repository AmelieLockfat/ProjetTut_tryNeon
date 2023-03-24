package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Semestre {
    @Id
    @GeneratedValue
    @Column(name = "idsemestre",insertable=false, updatable=false)
    private Long idsemestre;
    @Basic
    @Column(name = "numsemestre", nullable = false)
    private Integer numsemestre;
    @Basic
    @Column(name = "intituleniveau",insertable = false,updatable = false)
    private String intituleniveau;


    @ManyToOne
    @JoinColumn (name="intituleniveau", referencedColumnName ="intituleniveau",nullable=false )
   private Niveau niveau;

    @OneToMany(mappedBy = "semestre", cascade=CascadeType.REMOVE)
    private List<Ue> ues = new ArrayList<>();

    public Semestre(int numsemestre, String intituleniveau) {
        this.numsemestre = numsemestre;
        this.intituleniveau = intituleniveau;
    }

    public Semestre() {

    }

    public Long getIdsemestre() {
        return idsemestre;
    }

    public Integer getNumsemestre() {
        return numsemestre;
    }

    public String getIntituleniveau() {
        return intituleniveau;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public List<Ue> getUes() {
        return ues;
    }

    public boolean equals(Semestre semestre) {
        return this.idsemestre==semestre.getIdsemestre();
    }
}
