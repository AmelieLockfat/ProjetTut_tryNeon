package easyLabus.projet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.dao.PersonneinterneRepository;
import easyLabus.projet.dao.FicheENSRepository;
import easyLabus.projet.dao.IntervenantENSRepository;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.FicheENS;
import easyLabus.projet.entity.IntervenantENS;
import easyLabus.projet.entity.Personneinterne;

@Service
public class FicheENSService {
    private final EnseignementRepository enseignementDao;
    private final PersonneinterneRepository personneinterneDao;
    private final FicheENSRepository ficheENSDao;
    private final IntervenantENSRepository intervenantENSDao;

    public FicheENSService(EnseignementRepository enseignementDao,PersonneinterneRepository personneinterneDao, FicheENSRepository ficheENSDao,IntervenantENSRepository intervenantENSDao) {
        this.enseignementDao = enseignementDao;
        this.personneinterneDao = personneinterneDao;
        this.ficheENSDao = ficheENSDao;
        this.intervenantENSDao = intervenantENSDao;
    }

    @Transactional
    public FicheENS getFicheENS(String codeens){
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var now = LocalDate.now();
        var i = 0;
        if (now.getMonthValue()<8){
            i = 1;
        }
        var annee = now.getYear()-i+"/"+now.getYear();
        var FENS = ficheENSDao.ficheENSByYear(codeens,annee);
        ficheENSDao.delete(FENS);
        for (IntervenantENS intENS : FENS.getIntervenants()){
            intervenantENSDao.delete(intENS);
        }
        FENS = new FicheENS(ENS);
        for (Personneinterne p : ENS.getPersonnesinternes()){
            var intENS = new IntervenantENS(FENS, p);
            FENS.addIntervenant(intENS);
            intervenantENSDao.save(intENS);
        }
        ficheENSDao.save(FENS);
        return FENS;
    }

    @Transactional
    public FicheENS getFicheENS(String codeens, String annee){
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var now = LocalDate.now();
        var i = 0;
        if (now.getMonthValue()<8){
            i = 1;
        }
        var currentannee = now.getYear()-i+"/"+now.getYear();
        var FENS = ficheENSDao.ficheENSByYear(codeens,annee);
        ficheENSDao.delete(FENS);
        for (IntervenantENS intENS : FENS.getIntervenants()){
            intervenantENSDao.delete(intENS);
        }
        FENS = new FicheENS(ENS);
        for (Personneinterne p : ENS.getPersonnesinternes()){
            var intENS = new IntervenantENS(FENS, p);
            FENS.addIntervenant(intENS);
            intervenantENSDao.save(intENS);
        }
        ficheENSDao.save(FENS);
        return FENS;
    }
}