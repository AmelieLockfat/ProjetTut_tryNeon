package easyLabus.projet.dao;

import easyLabus.projet.entity.FicheUE;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheUERepository extends JpaRepository<FicheUE, Long> {

    ArrayList<FicheUE> findByCodeue(String codeue);
}
