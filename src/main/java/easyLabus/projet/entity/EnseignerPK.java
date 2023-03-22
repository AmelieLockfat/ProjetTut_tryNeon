package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.io.Serializable;

public class EnseignerPK implements Serializable {
    @Column(name = "identifiant")
    @Id
    private String identifiant;
    @Column(name = "codeens")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codeens;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getCodeens() {
        return codeens;
    }

    public void setCodeens(String codeens) {
        this.codeens = codeens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnseignerPK that = (EnseignerPK) o;

        if (identifiant != null ? !identifiant.equals(that.identifiant) : that.identifiant != null) return false;
        if (codeens != null ? !codeens.equals(that.codeens) : that.codeens != null) return false;

        return true;
    }
}
