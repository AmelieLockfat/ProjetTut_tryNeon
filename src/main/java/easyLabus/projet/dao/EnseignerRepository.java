package easyLabus.projet.dao;

import easyLabus.projet.entity.Enseigner;
import easyLabus.projet.entity.EnseignerPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignerRepository extends JpaRepository<Enseigner, EnseignerPK> {
}