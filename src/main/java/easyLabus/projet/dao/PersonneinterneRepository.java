package easyLabus.projet.dao;

import easyLabus.projet.dto.PersonneinterneSimple;
import easyLabus.projet.dto.ResponsableAnnee;
import easyLabus.projet.entity.Personneinterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneinterneRepository extends JpaRepository<Personneinterne, String> {

    @Query("SELECT pers.identifiant as identifiant, pers.motdepasse as motdepasse, pers.prenompers as prenompers, pers.nompers as nompers, pers.estdirecteur as estdirecteur, pers.niveau.intituleniveau as intituleniveau, pers.coordprivee as coordprivee, pers.numtel as numtel, pers.email as email "
                    + "FROM Personneinterne pers "
                    + "WHERE pers.identifiant = :identifiant AND pers.motdepasse = :motdepasse ")
    public PersonneinterneSimple getPersonneinterneByIdentifiantmdp(String identifiant, String motdepasse);
}

