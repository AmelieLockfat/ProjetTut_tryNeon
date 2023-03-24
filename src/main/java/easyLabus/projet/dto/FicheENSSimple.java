package easyLabus.projet.dto;

public interface FicheENSSimple {
    Long getIdficheENS();

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

    String getAnneedetude();
}