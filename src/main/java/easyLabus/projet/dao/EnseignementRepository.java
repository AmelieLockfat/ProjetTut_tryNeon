package easyLabus.projet.dao;

import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.dto.EnseignementSimple;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnseignementRepository extends JpaRepository<Enseignement, String> {

    @Query("SELECT ens.codeens as codeens, ens.nomens as nomens, ens.heurecm as heurecm, ens.heuretd as heuretd, ens.heuretp as heure tp, ens.heuretotalencadree as heuretotalencadree, ens.heuretravailperso as heuretravailperso, ens.coefficient as coefficient, ens.modalitesevaluation as modalitesevaluation, ens.prerequis as prerequis, ens.planducours as planducours, ens.contenu as contenu "
          +"FROM Enseignement ens "
          +"WHERE ens.codeue = :ue ")
    public List<EnseignementSimple> getByUe(String ue);
}
