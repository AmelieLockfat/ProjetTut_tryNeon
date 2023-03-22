package easyLabus.projet.dao;

import easyLabus.projet.entity.FicheUE;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheUERepository extends JpaRepository<FicheUE, Long> {

    List<FicheUE> findByCodeue(String codeue);
}
