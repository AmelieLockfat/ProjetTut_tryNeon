package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Semestre {
    @Id
    @GeneratedValue
    @Column(name = "idsemestre")
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

    @OneToMany(mappedBy = "semestre")
    private ArrayList<Ue> ues = new ArrayList<>();

    public Semestre(int numsemestre, Niveau niveau) {
        this.numsemestre = numsemestre;
        this.niveau = niveau;
        this.intituleniveau = niveau.getIntituleniveau();
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

    public ArrayList<Ue> getUes() {
        return ues;
    }

    public void setUes(ArrayList<Ue> ues) {
        this.ues = ues;
    }

    public void addUe(Ue ue) {
        ues.add(ue);
    }

    public void delUe(Ue ue) {
        ues.remove(ue);
    }

    public boolean equals(Semestre semestre) {
        return this.idsemestre==semestre.getIdsemestre();
    }
}
