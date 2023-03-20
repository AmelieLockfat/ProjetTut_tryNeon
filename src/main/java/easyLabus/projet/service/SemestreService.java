package easyLabus.projet.service;

import easyLabus.projet.dao.NiveauRepository;
import easyLabus.projet.dao.SemestreRepository;
import easyLabus.projet.entity.Semestre;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class SemestreService {

    private final SemestreRepository semestreDao ;
    private final NiveauRepository niveauDao;

    public SemestreService(SemestreRepository semestreDao, NiveauRepository niveauDao) {
        this.semestreDao = semestreDao;
        this.niveauDao = niveauDao;
    }
/*
    @Transactional(readOnly = true)
    public ArrayList<Semestre> getSemestrebyNiveau (String intituleniveau){
        var NIV = niveauDao.findById(intituleniveau).orElseThrow();
        return NIV.getSemestres();
    } */
}
