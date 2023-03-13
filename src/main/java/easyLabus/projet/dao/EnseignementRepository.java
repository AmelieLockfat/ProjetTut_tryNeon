package easyLabus.projet.dao;

import easyLabus.projet.entity.Enseignement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignementRepository extends JpaRepository<Enseignement, String> {
}
