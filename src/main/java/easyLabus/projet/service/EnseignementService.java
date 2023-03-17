package easyLabus.projet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.dao.PersonneinterneRepository;
import easyLabus.projet.dao.FicheENSRepository;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.FicheENS;

@Service
public class EnseignementService {
    private final EnseignementRepository enseignementDao;
    private final UeRepository ueDao;
    private final PersonneinterneRepository personneinterneDao;
    private final FicheENSRepository ficheENSDao;

    public EnseignementService(EnseignementRepository enseignementDao,UeRepository ueDao,PersonneinterneRepository personneinterneDao, FicheENSRepository ficheENSDao) {
        this.enseignementDao = enseignementDao;
        this.ueDao=ueDao;
        this.personneinterneDao=personneinterneDao;
        this.ficheENSDao=ficheENSDao;
    }

    @Transactional
    public Enseignement creerEnseignement (String codeens,String nomens,Double CM,Double TD,Double TP,String codeue, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis, String planducours) {
        if (enseignementDao.existsById(codeens)){
            return null;
        }
        else {
            var UE = ueDao.findById(codeue).orElseThrow();
            var ENS = new Enseignement(codeens,nomens,UE,CM,TD,TP,contenu,heuretravailperso,coefficient,modalitesevaluation,prerequis,planducours);
            enseignementDao.save(ENS);
            return ENS;
        }
    }

    @Transactional
    public Enseignement modifEnseignement(String codeens,String nomens,Double CM,Double TD,Double TP,String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis, String planducours) {
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        if (nomens!=null && !nomens.equals(ENS.getNomens())){
            ENS.setNomens(nomens);
        }
        if (CM!=null && CM!=ENS.getHeurecm()){
            ENS.setHeurecm(CM);
        }
        if (TD!=null && TD!=ENS.getHeuretd()){
            ENS.setHeuretd(TD);
        }
        if (TP!=null && TP!=ENS.getHeuretp()){
            ENS.setHeuretp(TP);
        }
        if (contenu!=null && contenu.equals(ENS.getContenu())){
            ENS.setContenu(contenu);
        }
        if (heuretravailperso!=null && heuretravailperso!=ENS.getHeuretravailperso()){
            ENS.setHeuretravailperso(heuretravailperso);
        }
        if (coefficient!=null && coefficient!=ENS.getCoefficient()){
            ENS.setCoefficient(coefficient);
        }
        if (modalitesevaluation!=null && !modalitesevaluation.equals(ENS.getModalitesevaluation())){
            ENS.setModalitesevaluation(modalitesevaluation);
        }
        if (prerequis!=null && !prerequis.equals(ENS.getPrerequis())){
            ENS.setPrerequis(prerequis);
        }
        if (planducours!=null && !planducours.equals(ENS.getPlanducours())){
            ENS.setPlanducours(planducours);
        }
        enseignementDao.save(ENS);
        return ENS;
    }

    @Transactional
    public Enseignement addEnseignant(String codeens,String identifiant) {
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var PERS = personneinterneDao.findById(identifiant).orElseThrow();
        ENS.addPersonneinterne(PERS);
        PERS.addEnseignement(ENS);
        enseignementDao.save(ENS);
        personneinterneDao.save(PERS);
        return ENS;
    }

    @Transactional
    public Enseignement delEnseignant(String codeens,String identifiant) {
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var PERS = personneinterneDao.findById(identifiant).orElseThrow();
        ENS.delPersonneinterne(PERS);
        PERS.delEnseignement(ENS);
        enseignementDao.save(ENS);
        personneinterneDao.save(PERS);
        return ENS;
    }

    @Transactional(readOnly = true)
    public FicheENS getFicheENS(String codeens){
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        return new FicheENS(ENS);
    }
}