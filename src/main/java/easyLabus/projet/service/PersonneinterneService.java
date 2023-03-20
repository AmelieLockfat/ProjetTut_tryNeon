package easyLabus.projet.service;

import java.util.List;

import easyLabus.projet.entity.Enseignement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.NiveauRepository;
import easyLabus.projet.dao.PersonneinterneRepository;
import easyLabus.projet.entity.Niveau;
import easyLabus.projet.entity.Personneinterne;

@Service
public class PersonneinterneService {
    private final EnseignementRepository enseignementDao;
    private final NiveauRepository niveauDao;
    private final PersonneinterneRepository personneinterneDao;

    public PersonneinterneService(PersonneinterneRepository personneinterneDao,NiveauRepository niveauDao,EnseignementRepository enseignementDao) {
        this.enseignementDao = enseignementDao;
        this.niveauDao=niveauDao;
        this.personneinterneDao=personneinterneDao;
    }

    @Transactional(readOnly = true)
	public Personneinterne getByIdPersonneinternes(String identifiant) {
		var PERS = personneinterneDao.findById(identifiant).orElseThrow();
        return new Personneinterne(identifiant, "",PERS.getPrenompers(),PERS.getNompers(),null,null,PERS.getNiveau(),null,PERS.getEstdirecteur());
	}

    @Transactional
    public Personneinterne creerPersonneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, String intituleniveau, Boolean coordprivee, Boolean estdirecteur){
        if (personneinterneDao.existsById(identifiant)){
            return null;
        }
        else {
            var PERS = new Personneinterne(identifiant, motdepasse, prenom, nom, email, numtel, null, coordprivee, estdirecteur);
            if (intituleniveau!=null){
                var NIV = niveauDao.findById(intituleniveau).orElseThrow();
                PERS.setNiveau(NIV);
            }
            personneinterneDao.save(PERS);
            return PERS;
        }
    }

    @Transactional
    public Personneinterne modifPersonneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, String intituleniveau, Boolean coordprivee, Boolean estdirecteur) {
        var PERS = personneinterneDao.findById(identifiant).orElseThrow();
        if (motdepasse!=null && !motdepasse.equals(PERS.getMotdepasse())){
            PERS.setMotdepasse(motdepasse);
        }
        if (prenom!=null && !prenom.equals(PERS.getPrenompers())){
            PERS.setPrenompers(prenom);
        }
        if (nom!=null && !nom.equals(PERS.getNompers())){
            PERS.setNompers(nom);
        }
        if (email!=null && !email.equals(PERS.getEmail())){
            PERS.setEmail(email);
        }
        if (numtel!=null && !numtel.equals(PERS.getNumtel())){
            PERS.setNumtel(numtel);
        }
        PERS.setNiveau(null);
        if (intituleniveau!=null){
            var NIV = niveauDao.findById(intituleniveau).orElseThrow();
            PERS.setNiveau(NIV);
        }
        if (coordprivee!=null && coordprivee!=PERS.getCoordPrivee()){
            PERS.modifCoordPrivee();
        }
        if (estdirecteur!=null && estdirecteur!=PERS.getEstdirecteur()){
            PERS.modifEstdirecteur();
        }
        personneinterneDao.save(PERS);
        return PERS;
    }

    @Transactional(readOnly = true)
    public boolean identifiantsValid(String identifiant, String motdepasse) {
        if (personneinterneDao.existsById(identifiant)){
            var PERS = personneinterneDao.findById(identifiant).get();
            if (motdepasse.equals(PERS.getMotdepasse())){
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void delPersonneinterne(String identifiant) {
        var PERS = personneinterneDao.findById(identifiant).orElseThrow();
        var L_ENS = PERS.getEnseignementsss();
        for (Enseignement ens : L_ENS){
            ens.delPersonneinterne(PERS);
        }
        personneinterneDao.delete(PERS);
    }


}
