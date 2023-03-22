package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity
public class Enseigner {

    @EmbeddedId
    EnseignerPK id;
}
