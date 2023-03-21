package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Diplome {
    @Id
    @Column(name = "intitulediplome")
    private String intitulediplome;

    @OneToMany(mappedBy = "diplome")
    private List<Orientation> orientations = new ArrayList<>();

    public Diplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }

    public Diplome() {

    }

    public String getIntitulediplome() {
        return intitulediplome;
    }

    public void setIntitulediplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }
    
    public List<Orientation> getOrientations() {
        return orientations;
    }

    public boolean equals(Diplome diplome) {
        return this.intitulediplome.equals(diplome.getIntitulediplome());
    }
}
