package easyLabus.projet.service;

import java.util.ArrayList;
import java.util.List;

import easyLabus.projet.dto.ContenuSimple;
import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.FausseFicheUESimple;
import easyLabus.projet.dto.IntervenantUESimple;
import easyLabus.projet.dto.UeSimple;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.Personneinterne;
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
    public List<UeSimple> getUeBySemestre (Long idsemestre){
        var SEM = semestreDao.findById(idsemestre).orElseThrow();
        return ueDao.getUeSimples(SEM.getIdsemestre());
    }

    @Transactional(readOnly = true)
    public FausseFicheUESimple getFiche (String codeue) {
        return ueDao.getFicheActu(codeue);
    }

    @Transactional(readOnly = true)
    public List<IntervenantUESimple> getIntervenants (String codeue) {
        return ueDao.getIntervenants(codeue);
    }

    @Transactional(readOnly = true)
    public List<ContenuSimple> getContenus (String codeue) {
        return ueDao.getContenus(codeue);
    }

    @Transactional(readOnly = true)
    public UeSimple getBycodeue (String codeue) {
        return ueDao.getBycode(codeue);
    }

    @Transactional
    public EnseignementSimple addNewEnseignement (String codeue, String codeens, String nomens, String contenu) {
        var UE = ueDao.findById(codeue).orElseThrow();
        Enseignement ENS = new Enseignement(codeens,nomens,codeue,0.0,0.0,0.0,contenu);
        enseignementDao.save(ENS);
        ueDao.save(UE);
        return enseignementDao.getSimpleByCodeens(codeens);
    }

/*
    @Transactional
    public Ue delEnseignement(String codeue,String codeens) {
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var ue = ueDao.findById(codeue).orElseThrow();
        ue.delEnseignement(ENS);
        enseignementDao.delete(ENS);
        return ue;
    }

    @Transactional
    public Ue creerUe (String codeue, String intituleue, Long idsemestre, Integer creditsects, Double volumtravailperso, Double volumprojet, Double volumstage, String modalitescontrole, String prerequis, String bibliographiedebase, Integer ordreue, String motcles, String competenses) {
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
    public Enseignement addEnseignement(String codeue, String codeens) {
        var ENS = enseignementDao.findById(codeens).orElseThrow();
        var ue = ueDao.findById(codeue).orElseThrow();
        ue.addEnseignement(ENS);
        ENS.setUe(ue);
        enseignementDao.save(ENS);
        ueDao.save(ue);
        return ENS;
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
       // if (volumstage!=null && volumstage!=UE.getVolumstage()){
         //   UE.setVolumstage(volumstage);
       // }
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
    }*/

    @Transactional
    public void delUe(String codeue) {
        ueDao.deleteById(codeue);
    }
}
