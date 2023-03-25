package easyLabus.projet.dao;

import easyLabus.projet.dto.UeSimple;
import easyLabus.projet.entity.Ue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UeRepository extends JpaRepository<Ue, String> {

    @Query(nativeQuery=true ,
            value = " SELECT ues.codeue as codeue, ues.intituleue "
                    + "FROM Ue ues "
                    + "WHERE ues.idsemestre = :idsemestre ")
    public List<UeSimple> getUeSimples(Long idsemestre) ;
}
