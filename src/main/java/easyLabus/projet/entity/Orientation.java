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
    private Diplome Diplomebyintitulediplome;

    @OneToMany(mappedBy = "Orientationbynomorientation")
    private List<Niveau> Niveaubyorientation = new ArrayList<>();

    public String getNomorientation() {
        return nomorientation;
    }

    public void setNomorientation(String nomorientation) {
        this.nomorientation = nomorientation;
    }

    public String getIntitulediplome() {
        return intitulediplome;
    }

    public void setIntitulediplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orientation that = (Orientation) o;

        if (nomorientation != null ? !nomorientation.equals(that.nomorientation) : that.nomorientation != null)
            return false;
        if (intitulediplome != null ? !intitulediplome.equals(that.intitulediplome) : that.intitulediplome != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomorientation != null ? nomorientation.hashCode() : 0;
        result = 31 * result + (intitulediplome != null ? intitulediplome.hashCode() : 0);
        return result;
    }
}
