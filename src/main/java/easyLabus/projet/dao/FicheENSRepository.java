package easyLabus.projet.dao;

import easyLabus.projet.entity.FicheENS;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FicheENSRepository extends JpaRepository<FicheENS, Long> {

    /*@Query("SELECT * "
         + "FROM FicheENS "
         + "WHERE codeens = :codeens "
         + "AND anneedetude = :annee ")
    public FicheENS ficheENSByYear(String codeens, String annee);*/
}
