package easyLabus.projet.rest;

import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.FausseFicheENSSimple;
import easyLabus.projet.dto.IntervenantENSSimple;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.FicheENS;
import easyLabus.projet.service.EnseignementService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/enseignements")
public class EnseignementController {
	private final EnseignementService enseignementService;
	// @Autowired
	public EnseignementController(EnseignementService enseignementService) {
		this.enseignementService = enseignementService;
	}

    @GetMapping("ByUe")
    public List<EnseignementSimple> getByUe(
        @RequestParam(required = true) String codeue){

        return enseignementService.getByUe(codeue);
    }

    @GetMapping("Fiche")
    public FausseFicheENSSimple getFicheENS(
        @RequestParam(required = true) String codeens) {

        return enseignementService.getFiche(codeens);
    }

    @GetMapping("Intervenants")
    public List<IntervenantENSSimple> getIntervenants(
        @RequestParam(required = true) String codeens) {

        return enseignementService.getIntervenants(codeens);
    }

/*
	@PostMapping(path = "new")
    public Enseignement creerEns(
        @RequestParam(required = true) String codeens, 
        @RequestParam(required = true) String nomens,  
        @RequestParam(required = true) Double CM,  
        @RequestParam(required = true) Double TD,  
        @RequestParam(required = true) Double TP,  
        @RequestParam(required = true) String codeue,  
        @RequestParam(required = false) String contenu,  
        @RequestParam(required = false) Double heuretravailperso,  
        @RequestParam(required = false) Double coefficient,  
        @RequestParam(required = false) String modalitesevaluation,  
        @RequestParam(required = false) String prerequis,  
        @RequestParam(required = false) String planducours) {

        return enseignementService.creerEnseignement(codeens,nomens,CM,TD,TP,codeue,contenu,heuretravailperso,coefficient,modalitesevaluation,prerequis,planducours);
    }

    @PutMapping(path = "{codeens}/modif")
    public Enseignement modifEns(
        @PathVariable String codeens, 
        @RequestParam(required = false) String nomens,  
        @RequestParam(required = false) Double CM,  
        @RequestParam(required = false) Double TD,  
        @RequestParam(required = false) Double TP,  
        @RequestParam(required = false) String contenu,  
        @RequestParam(required = false) Double heuretravailperso,  
        @RequestParam(required = false) Double coefficient,  
        @RequestParam(required = false) String modalitesevaluation,  
        @RequestParam(required = false) String prerequis,  
        @RequestParam(required = false) String planducours) {

        return enseignementService.modifEnseignement(codeens,nomens,CM,TD,TP,contenu,heuretravailperso,coefficient,modalitesevaluation,prerequis,planducours);
    }

    @PutMapping(path = "{codeens}/addpersonneinterne")
    public Enseignement addPers(
        @PathVariable String codeens,
        @RequestParam(required = true) String identifiant) {

        return enseignementService.addEnseignant(codeens, identifiant);
    }

    @PutMapping(path = "{codeens}/delpersonneinterne")
    public Enseignement delPers(
        @PathVariable String codeens,
        @RequestParam(required = true) String identifiant) {

        return enseignementService.delEnseignant(codeens, identifiant);
    }

    @GetMapping(path = "{codeens}/fiche")
    public FicheENS getFiche(
        @PathVariable String codeens) {

        return enseignementService.getFicheENS(codeens);
    }*/
}