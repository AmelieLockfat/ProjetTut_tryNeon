package easyLabus.projet.rest;

import easyLabus.projet.dto.EnseignementDTO;
import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.service.EnseignementService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/easyLabus/enseignement")
public class EnseignementController {
	private final EnseignementService enseignementService;
	// @Autowired
	public EnseignementController(EnseignementService enseignementService) {
		this.enseignementService = enseignementService;
	}

	@GetMapping(path = "")
	public List<Enseignement> getEnseignements() {
		return enseignementService.allEnseignement();
	}

	@PostMapping(path = "modifENS")
    public Enseignement gEnseignement(
        @RequestParam(required = true) String codeens, 
        @RequestParam(required = false) String nomens,  
        @RequestParam(required = false) Double CM,  
        @RequestParam(required = false) Double TD,  
        @RequestParam(required = false) Double TP,  
        @RequestParam(required = false) String codeue,  
        @RequestParam(required = false) String contenu,  
        @RequestParam(required = false) Double heuretravailperso,  
        @RequestParam(required = false) Double coefficient,  
        @RequestParam(required = false) String modalitesevaluation,  
        @RequestParam(required = false) String prerequis,  
        @RequestParam(required = false) String planducours) {

        return enseignementService.gEnseignement(codeens,nomens,CM,TD,TP,codeue,contenu,heuretravailperso,coefficient,modalitesevaluation, String prerequis, String planducours);
    }
}