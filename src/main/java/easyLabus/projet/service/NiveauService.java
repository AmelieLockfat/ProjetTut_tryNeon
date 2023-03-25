package easyLabus.projet.service;

import java.util.List;

import easyLabus.projet.dao.NiveauRepository;
import easyLabus.projet.dto.NiveauSimple;
import easyLabus.projet.dto.ResponsableAnnee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NiveauService {
    private final NiveauRepository niveauDao;

    public NiveauService(NiveauRepository niveauDao) {
        this.niveauDao = niveauDao;
    }

    @Transactional(readOnly = true)
    public List<NiveauSimple> getAll () {
        return niveauDao.getNiveaux();
    }

    @Transactional(readOnly = true)
    public ResponsableAnnee getResponsable (String intituleniveau) {
        return niveauDao.getResponsable(intituleniveau);
    }
}
