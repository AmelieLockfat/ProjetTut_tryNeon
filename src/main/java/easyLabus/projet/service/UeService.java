package easyLabus.projet.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easyLabus.projet.dao.UeRepository;
import easyLabus.projet.dao.EnseignementRepository;
import easyLabus.projet.dao.FicheUERepository;
import easyLabus.projet.entity.Ue;
import easyLabus.projet.entity.FicheUE;

@Service
public class UeService {
    private final UeRepository ueDao;
    private final EnseignementRepository enseignementDao;
    private final FicheUERepository ficheUEDao;

    public UeService(UeRepository ueDao, EnseignementRepository enseignementDao, FicheUERepository ficheUEDao) {
        this.ueDao=ueDao;
        this.enseignementDao = enseignementDao;
        this.ficheUEDao=ficheUEDao;
    }
}
