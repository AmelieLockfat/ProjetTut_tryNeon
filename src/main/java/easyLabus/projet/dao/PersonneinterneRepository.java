package easyLabus.projet.dao;

import easyLabus.projet.dto.PersonneinterneSimple;
import easyLabus.projet.dto.ResponsableAnnee;
import easyLabus.projet.entity.Personneinterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneinterneRepository extends JpaRepository<Personneinterne, String> {

    @Query(nativeQuery = true, value =
            "SELECT pers.identifiant, pers.motdepasse, pers.prenompers, pers.nompers, pers.estdirecteur, pers.intituleniveau, pers.coordprive, pers.numtel, pers.email "
                    + "FROM Personneinterne pers "
                    + "WHERE pers.identifiant = :identifiant AND pers.motdepasse = :motdepasse ")
    public PersonneinterneSimple getPersonneinterneByIdentifiantmdp(String identifiant, String motdepasse);
}

