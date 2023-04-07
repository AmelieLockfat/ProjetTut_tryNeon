package easyLabus.projet.dto;

import easyLabus.projet.entity.Enseignement;


import java.util.List;

public interface PersonneinterneSimple {

    String getIdentifiant();
    String getMotdepasse();
    String getPrenompers();
    String getNompers();
    Boolean getEstdirecteur();
    String getIntituleniveau();

    Boolean getCoordprivee();
    String getNumtel();
    String getEmail();


}
