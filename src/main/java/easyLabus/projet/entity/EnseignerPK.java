package easyLabus.projet.entity;

import jakarta.persistence.*;

@Embeddable
public class EnseignerPK {
    String identifiant;
    String codeens;
}
