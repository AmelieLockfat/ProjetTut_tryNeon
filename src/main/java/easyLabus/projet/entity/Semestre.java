package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Semestre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsemestre")
    private Integer idsemestre;
    @Basic
    @Column(name = "numsemestre")
    private Integer numsemestre;
    @Basic
    @Column(name = "intituleniveau",insertable = false,updatable = false)
    private String intituleniveau;


    @ManyToOne
    @JoinColumn (name="intituleniveau", referencedColumnName ="intituleniveau",nullable=false )
   private Niveau Niveaubyintituleniveau;

    @OneToMany(mappedBy = "Semestrebyidsemestre")
    private List<Ue> Uebysemestre = new ArrayList<>();

    public Integer getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(Integer idsemestre) {
        this.idsemestre = idsemestre;
    }

    public Integer getNumsemestre() {
        return numsemestre;
    }

    public void setNumsemestre(Integer numsemestre) {
        this.numsemestre = numsemestre;
    }

    public String getIntituleniveau() {
        return intituleniveau;
    }

    public void setIntituleniveau(String intituleniveau) {
        this.intituleniveau = intituleniveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestre semestre = (Semestre) o;

        if (idsemestre != null ? !idsemestre.equals(semestre.idsemestre) : semestre.idsemestre != null) return false;
        if (numsemestre != null ? !numsemestre.equals(semestre.numsemestre) : semestre.numsemestre != null)
            return false;
        if (intituleniveau != null ? !intituleniveau.equals(semestre.intituleniveau) : semestre.intituleniveau != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsemestre != null ? idsemestre.hashCode() : 0;
        result = 31 * result + (numsemestre != null ? numsemestre.hashCode() : 0);
        result = 31 * result + (intituleniveau != null ? intituleniveau.hashCode() : 0);
        return result;
    }
}
