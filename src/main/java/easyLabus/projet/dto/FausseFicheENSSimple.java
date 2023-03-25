package easyLabus.projet.dto;

import java.util.List;

public interface FausseFicheENSSimple {
    String getCodeens();
    String getNomens();
    Double getHeurecm();
    Double getHeuretd();
    Double getHeuretp();
    Double getHeuretotalencadree();
    Double getHeuretravailperso();
    Double getCoefficient();
    String getModalitesevaluation();
    String getPrerequis();
    String getPlanducours();

    String getCodeue();
    String getIntituleue();

    int getNumsemestre();

    //List<IntervenantENSSimple> getIntervenants();
}