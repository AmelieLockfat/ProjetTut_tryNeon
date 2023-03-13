package easyLabus.projet.entity;

import jakarta.persistence.*;

@Entity

public class Enseigner {

    @Id
    @Column(name="identifiant")
    private String identifiant;

    @Id
    @Column(name="codeens")
    private String codeens;






}
