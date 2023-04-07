package easyLabus.projet.service;

import easyLabus.projet.dao.NiveauRepository;
import easyLabus.projet.dao.SemestreRepository;
import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.SemestreSimple;
import easyLabus.projet.dto.UeSimple;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.Semestre;
import easyLabus.projet.entity.Ue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemestreService {


    private final SemestreRepository semestreDao ;
    private final NiveauRepository niveauDao;

    private final UeRepository ueDao ;

    public SemestreService(SemestreRepository semestreDao, NiveauRepository niveauDao, UeRepository ueDao) {
        this.semestreDao = semestreDao;
        this.niveauDao = niveauDao;
        this.ueDao = ueDao;
    }

    @Transactional
    public UeSimple addNewUe (String codeue, String intitule, Long idSemestre) {
        var semestre = semestreDao.findById(idSemestre).orElseThrow();
        Ue nUE = new Ue(codeue,intitule,idSemestre,0,0.0,0.0,0.0,null,null,null,null,null,null);
        ueDao.save(nUE);
        semestreDao.save(semestre);
        return ueDao.getBycode(codeue);
    }


    @Transactional(readOnly = true)
    public List<SemestreSimple> getSemestreByNiveau (String intituleniveau){
        return semestreDao.getByIntituleniveau(intituleniveau);
    }
}
