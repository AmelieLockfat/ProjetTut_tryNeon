package easyLabus.projet.dao;


import easyLabus.projet.entity.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, String> {
}
