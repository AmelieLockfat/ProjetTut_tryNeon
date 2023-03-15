package easyLabus.projet.service;

import java.util.List;

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
	public List<Personneinterne> allPersonneinternes() {
		return personneinterneDao.findAll();
	}

    @Transactional
    public Personneinterne gPersonneinterne(String identifiant, String motdepasse, String prenom, String nom, String email, String numtel, String intituleniveau, Boolean coordprivee, Boolean estdirecteur) {
        if (personneinterneDao.existsById(identifiant)){
            var PERS = personneinterneDao.findById(identifiant).get();
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
            if (intituleniveau!=null && !intituleniveau.equals(PERS.getIntituleniveau())){
                PERS.setNiveau(niveauDao.findById(intituleniveau).orElseThrow());
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
        var PERS = new Personneinterne(identifiant, motdepasse, prenom, nom, email, numtel, null, coordprivee, estdirecteur);
        if (intituleniveau!=null){
            var NIV = niveauDao.findById(intituleniveau).orElseThrow();
            PERS.setNiveau(NIV);
        }
        personneinterneDao.save(PERS);
        return PERS;
    }
}
