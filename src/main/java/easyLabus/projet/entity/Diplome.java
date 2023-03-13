package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Diplome {
    @Id
    @Column(name = "intitulediplome")
    private String intitulediplome;

    @OneToMany(mappedBy = "Diplomebyintitulediplome")
    private List<Orientation> Orientationbydiplome = new ArrayList<>();

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

        Diplome diplome = (Diplome) o;

        if (intitulediplome != null ? !intitulediplome.equals(diplome.intitulediplome) : diplome.intitulediplome != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return intitulediplome != null ? intitulediplome.hashCode() : 0;
    }
}
