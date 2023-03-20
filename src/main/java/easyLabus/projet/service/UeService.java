package easyLabus.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.FicheUERepository;
import easyLabus.projet.dao.SemestreRepository;
import easyLabus.projet.entity.Ue;
import easyLabus.projet.entity.FicheUE;

@Service
public class UeService {
    private final UeRepository ueDao;
    private final EnseignementRepository enseignementDao;
    private final FicheUERepository ficheUEDao;
    private final SemestreRepository semestreDao;

    public UeService(UeRepository ueDao, EnseignementRepository enseignementDao, FicheUERepository ficheUEDao, SemestreRepository semestreDao) {
        this.ueDao=ueDao;
        this.enseignementDao = enseignementDao;
        this.ficheUEDao=ficheUEDao;
        this.semestreDao=semestreDao;
    }

    @Transactional(readOnly = true)
    public ArrayList<Ue> getUeBySemestre (int idsemestre){
        var SEM = semestreDao.findById(idsemestre).orElseThrow();
        return SEM.getUes();
    }

    @Transactional
    public Ue creerUe (String codeue, String intituleue, int idsemestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue, String motcles, String competenses) {
        if (ueDao.existsById(codeue)){
            return null;
        }
        else {
            var SEM = semestreDao.findById(idsemestre).orElseThrow();
            var UE = new Ue(codeue, intituleue, SEM, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase, ordreue, motcles, competenses);
            SEM.addUe(UE);
            ueDao.save(UE);
            semestreDao.save(SEM);
            return UE;
        }
    }

    @Transactional
    public Ue modifUe(String codeue, String intituleue, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue, String motcles, String competenses) {
        var UE = ueDao.findById(codeue).orElseThrow();
        if (intituleue!=null && !intituleue.equals(UE.getIntituleue())){
            UE.setIntituleue(intituleue);
        }
        if (creditsects!=null && creditsects!=UE.getCreditsects()){
            UE.setCreditsects(creditsects);
        }
        if (volumtravailperso!=null && volumtravailperso!=UE.getVolumtravailperso()){
            UE.setVolumtravailperso(volumtravailperso);
        }
        if (volumprojet!=null && volumprojet!=UE.getVolumprojet()){
            UE.setVolumprojet(volumprojet);
        }
        if (volumstage!=null && volumstage!=UE.getVolumstage()){
            UE.setVolumstage(volumstage);
        }
        if (modalitescontrole!=null && !modalitescontrole.equals(UE.getModalitescontrole())){
            UE.setModalitescontrole(modalitescontrole);
        }
        if (prerequis!=null && !prerequis.equals(UE.getPrerequis())){
            UE.setPrerequis(prerequis);
        }
        if (bibliographiedebase!=null && !bibliographiedebase.equals(UE.getBibliographiedebase())){
            UE.setBibliographiedebase(bibliographiedebase);
        }
        if (ordreue!=null && ordreue!=UE.getOrdreue()){
            UE.setOrdreue(ordreue);
        }
        if (motcles!=null && !motcles.equals(UE.getMotcles())){
            UE.setMotcles(motcles);
        }
        if (competenses!=null && !competenses.equals(UE.getCompetenses())){
            UE.setCompetenses(competenses);
        }
        ueDao.save(UE);
        var SEM = semestreDao.findById(UE.getIdsemestre()).get();
        SEM.delUe(UE);
        SEM.addUe(UE);
        semestreDao.save(SEM);
        return UE;
    }

    @Transactional(readOnly = true)
    public FicheUE getFicheUE(String codeue){
        var UE = ueDao.findById(codeue).orElseThrow();
        return new FicheUE(UE);
    }
}
