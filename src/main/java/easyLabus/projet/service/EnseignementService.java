package easyLabus.projet.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.entity.Enseignement;
import jakarta.transaction.Transactional;

@Service
public class EnseignementService {
    private final EnseignementRepository enseignementDao;
    private final UeRepository ueDao;

    public EnseignementService(EnseignementRepository enseignementDao,UeRepository ueDao) {
        this.enseignementDao = enseignementDao;
        this.ueDao=ueDao;
    }

    public Enseignement gEnseignement(String codeens,String nomens,Double CM,Double TD,Double TP,String codeue, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis, String planducours) {
        var UE = ueDao.findById(codeue).orElseThrow();
        if (enseignementDao.existsById(codeens)){
            var ENS = enseignementDao.findById(codeens).get();
            if (!nomens.equals(ENS.getNomens())){
                ENS.setNomens(nomens);
            }
            if (CM!=ENS.getHeurecm()){
                ENS.setHeurecm(CM);
            }
            if (CM!=ENS.getHeuretd()){
                ENS.setHeuretd(TD);
            }
            if (CM!=ENS.getHeuretp()){
                ENS.setHeuretp(TP);
            }
            if (contenu.equals(ENS.getContenu())){
                ENS.setContenu(contenu);
            }
            if (heuretravailperso!=ENS.getHeuretravailperso()){
                ENS.setHeuretravailperso(heuretravailperso);
            }
            if (coefficient!=ENS.getCoefficient()){
                ENS.setCoefficient(coefficient);
            }
            enseignementDao.save(ENS);
            return ENS;
        }
        else {
            var ENS = new Enseignement(codeens,nomens,UE,CM,TD,TP,contenu,heuretravailperso,coefficient,modalitesevaluation,prerequis,planducours);
            enseignementDao.save(ENS);
            return ENS;
        }
    }
}