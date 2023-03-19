package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Diplome {
    @Id
    @Column(name = "intitulediplome")
    private String intitulediplome;

    @OneToMany(mappedBy = "Diplomebyintitulediplome")
    private ArrayList<Orientation> orientations = new ArrayList<>();

    public Diplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }

    public String getIntitulediplome() {
        return intitulediplome;
    }

    public void setIntitulediplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }
    
    public ArrayList<Orientation> getOrientations() {
        return orientations;
    }

    public void setOrientations(ArrayList<Orientation>) {
        this.orientations = orientations;
    }

    public void addOrientation(Orientation orientation) {
        orientations.add(orientation);
    }

    public void delOrientation(Orientation orientation) {
        orientations.remove(orientation);
    }

    public boolean equals(Diplome diplome) {
        return this.intitulediplome.equals(diplome.getIntitulediplome());
    }
}
