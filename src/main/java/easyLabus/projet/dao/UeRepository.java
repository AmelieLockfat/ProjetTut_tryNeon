package easyLabus.projet.dao;

import easyLabus.projet.dto.ContenuSimple;
import easyLabus.projet.dto.FausseFicheUESimple;
import easyLabus.projet.dto.IntervenantUESimple;
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

    @Query("SELECT u.codeue as codeue, u.intituleue as intituleue, u.creditsects as creditsects, u.semestre.niveau.orientation.diplome.intitulediplome as intitulediplome, u.semestre.niveau.orientation.nomorientation as nomorientation, u.semestre.niveau.intituleniveau as intituleniveau, u.semestre.numsemestre as numsemestre, u.ordreue as ordreue, u.motcles as motcles, u.competenses as competenses, u.heurecm as heurecm, u.heuretd as heuretd, u.heuretp as heuretp, u.volumtravailperso as volumtravailperso, u.volumprojet as volumprojet, u.volumstage as volumstage, u.prerequis as prerequis, u.modalitescontrole as modalitescontrole, u.bibliographiedebase as bibliographiedebase "
          +"FROM Ue u "
          +"WHERE u.codeue = :code ")
    public FausseFicheUESimple getFicheActu(String code);

    @Query(nativeQuery = true, value = 
           "SELECT ens.codeens as codeens, ens.nomens as nomens, ens.contenu as contenu "
          +"FROM Enseignement ens "
          +"WHERE ens.codeue = :code ")
    public List<ContenuSimple> getContenus(String code);

    // MARCHE TRES BIEN :) //
    @Query(nativeQuery = true, value =
          "SELECT DISTINCT pers.identifiant as identifiant, pers.prenompers as prenompers, pers.nompers as nompers "
         +"FROM Personneinterne pers INNER JOIN Enseigner er on pers.identifiant=er.identifiant "
                  +"INNER JOIN Enseignement ens ON er.codeens=ens.codeens "
                  +"INNER JOIN Ue u ON ens.codeue = u.codeue "
         +"WHERE u.codeue = :code ")
    public List<IntervenantUESimple> getIntervenants(String code);


    @Query(nativeQuery=true ,
            value = " SELECT ues.codeue as codeue, ues.intituleue as intituleue "
                    + "FROM Ue ues "
                    + "WHERE ues.codeue = :codeue ")
    public UeSimple getBycode(String codeue) ;
}
