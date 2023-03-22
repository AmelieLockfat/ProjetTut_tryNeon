package easyLabus.projet.dao;


import easyLabus.projet.dto.SemestreSimple;
import easyLabus.projet.entity.Semestre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    @Query("SELECT * "
         + "FROM Semestre "
         + "WHERE intituleniveau = :niveau "
         + "AND anneedetude = :annee ")
    public List<SemestreSimple> getByIntituleniveau(String niveau);
}
