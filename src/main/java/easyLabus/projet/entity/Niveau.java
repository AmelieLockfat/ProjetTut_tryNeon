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
    private Orientation Orientationbynomorientation;


    @OneToMany(mappedBy = "Niveaubyintituleniveau")
    private List<Semestre> Semestrebyniveau = new ArrayList<>();



    public String getIntituleniveau() {
        return intituleniveau;
    }

    public void setIntituleniveau(String intituleniveau) {
        this.intituleniveau = intituleniveau;
    }

    public String getNomorientation() {
        return nomorientation;
    }

    public void setNomorientation(String nomorientation) {
        this.nomorientation = nomorientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Niveau niveau = (Niveau) o;

        if (intituleniveau != null ? !intituleniveau.equals(niveau.intituleniveau) : niveau.intituleniveau != null)
            return false;
        if (nomorientation != null ? !nomorientation.equals(niveau.nomorientation) : niveau.nomorientation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intituleniveau != null ? intituleniveau.hashCode() : 0;
        result = 31 * result + (nomorientation != null ? nomorientation.hashCode() : 0);
        return result;
    }
}
