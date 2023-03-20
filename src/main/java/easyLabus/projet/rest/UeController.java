package easyLabus.projet.rest;

import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.FicheENS;
import easyLabus.projet.entity.Ue;
import easyLabus.projet.entity.FicheUE;
import easyLabus.projet.service.UeService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/easyLabus/ue")
public class UeController {
	private final UeService ueService;
	// @Autowired
	public UeController(UeService ueService) {
		this.ueService = ueService;
	}

	@PostMapping(path = "new")
    public Ue creerUe(
        @RequestParam(required = true) String codeue, 
        @RequestParam(required = true) String intituleue,  
        @RequestParam(required = true) int idsemestre,  
        @RequestParam(required = true) Integer creditsects,  
        @RequestParam(required = true) Double volumtravailperso,  
        @RequestParam(required = true) Double volumprojet,  
        @RequestParam(required = true) Double volumstage,  
        @RequestParam(required = false) String modalitescontrole,  
        @RequestParam(required = false) String prerequis,  
        @RequestParam(required = false) String bibliographiedebase,  
        @RequestParam(required = false) Integer ordreue,  
        @RequestParam(required = false) String motcles,  
        @RequestParam(required = false) String competenses) {

        return ueService.creerUe(codeue, intituleue, idsemestre, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase, ordreue, motcles, competenses);
    }

	@PutMapping(path = "{codeue}/modif")
    public Ue modifUe(
    @PathVariable String codeue, 
    @RequestParam(required = false) String intituleue,  
    @RequestParam(required = false) Integer creditsects,  
    @RequestParam(required = false) Double volumtravailperso,  
    @RequestParam(required = false) Double volumprojet,  
    @RequestParam(required = false) Double volumstage,  
    @RequestParam(required = false) String modalitescontrole,  
    @RequestParam(required = false) String prerequis,  
    @RequestParam(required = false) String bibliographiedebase,  
    @RequestParam(required = false) Integer ordreue,  
    @RequestParam(required = false) String motcles,  
    @RequestParam(required = false) String competenses) {

    return ueService.modifUe(codeue, intituleue, creditsects, volumtravailperso, volumprojet, volumstage, modalitescontrole, prerequis, bibliographiedebase, ordreue, motcles, competenses);
}

	@GetMapping(path = "{codeue}/fiche")
    public FicheUE getFiche(
        @PathVariable String codeue) {

        return ueService.getFicheUE(codeue);
    }

    @GetMapping(path = "{codeue}/addEnseignement")
    public Enseignement addEnseingment(
            @PathVariable String codeue,
    @RequestParam(required = true) String codeens)
    {
        return ueService.addEnseignement(codeue,codeens);
    }

    @PutMapping(path = "{codeue}/delEnseignement")
    public Enseignement delEnseignement(
            @PathVariable String codeue,
            @RequestParam(required = true) String codeens) {

        return ueService.delEnseignement(codeue,codeens);
    }
}
