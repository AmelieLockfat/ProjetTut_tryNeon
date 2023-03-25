package easyLabus.projet.dao;

import easyLabus.projet.dto.NiveauSimple;
import easyLabus.projet.dto.ResponsableAnnee;
import easyLabus.projet.entity.Niveau;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NiveauRepository extends JpaRepository<Niveau, String> {

    @Query(nativeQuery = true, value = 
           "SELECT niv.intituleniveau as intituleniveau "
         + "FROM Niveau niv ")
    public List<NiveauSimple> getNiveaux();

    // NE MARCHE PEUT ETRE PAS //
    @Query(nativeQuery = true, value = 
           "SELECT pers.identifiant as identifiant, pers.prenompers as prenompers, pers.nompers as nompers "
         + "FROM Personneinterne pers "
         + "WHERE pers.intituleniveau = :intNiv AND pers.identifiant IN (SELECT er.identifiant FROM Enseigner er) ")
    public ResponsableAnnee getResponsable(String intNiv);
}
