package easyLabus.projet.rest;

import easyLabus.projet.dto.ContenuSimple;
import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.PersonneinterneSimple;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.entity.Personneinterne;
import easyLabus.projet.service.PersonneinterneService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/personneinternes")
public class PersonneinterneController {
    private final PersonneinterneService personneinterneService;
	// @Autowired
	public PersonneinterneController(PersonneinterneService personneinterneService) {
		this.personneinterneService = personneinterneService;
	}

	@GetMapping(path = "ByIdAMdp")
    public PersonneinterneSimple ByIdentifantEtMotdepasse(
        @RequestParam(required = true) String identifiant,
        @RequestParam(required = true) String motdepasse) {

		return personneinterneService.getPersonneinterneByIdentifiant(identifiant, motdepasse);
	}

    @PostMapping("AddPersonneinterne")
    public PersonneinterneSimple addPERS(
            @RequestBody Map<String, String> newPersonneinterneJSON,
            @RequestParam(required = true) String identifiant) {
        return personneinterneService.addPERS(identifiant,newPersonneinterneJSON.get("motdepasse"),newPersonneinterneJSON.get("prenompers"),newPersonneinterneJSON.get("nompers"),newPersonneinterneJSON.get("email"),newPersonneinterneJSON.get("numtel"));
    }
  /* @GetMapping(path = "{identifiant}")
    public Personneinterne getPers(
        @PathVariable String identifiant) {
        
        return personneinterneService.getByIdPersonneinternes(identifiant);
    }

    @PostMapping(path = "new")
    public Personneinterne creerPers(
        @RequestParam(required = true) String identifiant,
        @RequestParam(required = true) String motdepasse,
        @RequestParam(required = true) String prenom,
        @RequestParam(required = true) String nom,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String numtel,
        @RequestParam(required = false) String intituleniveau,
        @RequestParam(required = false) Boolean coordprivee,
        @RequestParam(required = false) Boolean estdirecteur) {

        return personneinterneService.creerPersonneinterne(identifiant, motdepasse, prenom, nom, email, numtel, intituleniveau, coordprivee, estdirecteur);
    }

    @PutMapping(path = "{identifiant}/modif")
    public Personneinterne modifPers(
        @PathVariable String identifiant,
        @RequestParam(required = false) String motdepasse,
        @RequestParam(required = false) String prenom,
        @RequestParam(required = false) String nom,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String numtel,
        @RequestParam(required = false) String intituleniveau,
        @RequestParam(required = false) Boolean coordprivee,
        @RequestParam(required = false) Boolean estdirecteur) {

        return personneinterneService.modifPersonneinterne(identifiant, motdepasse, prenom, nom, email, numtel, intituleniveau, coordprivee, estdirecteur);
    }
*/
    @GetMapping(path = "connect")
    public boolean identsValid(
        @RequestParam(required = true) String identifiant,
        @RequestParam(required = true) String motdepasse) {

        return personneinterneService.identifiantsValid(identifiant, motdepasse);
    }
/*
    @PutMapping(path = "{identifiant}/delPersonneinterne")
    public void delPersonneinterne(
            @PathVariable String identifiant)
            {
                personneinterneService.delPersonneinterne(identifiant);
    }*/
}
