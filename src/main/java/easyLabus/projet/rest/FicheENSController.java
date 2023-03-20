package easyLabus.projet.rest;

import easyLabus.projet.entity.FicheENS;
import easyLabus.projet.service.FicheENSService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/easyLabus/enseignement/fiche")
public class FicheENSController {
	private final FicheENSService ficheENSService;
	// @Autowired
	public FicheENSController(FicheENSService ficheENSService) {
		this.ficheENSService = ficheENSService;
	}

    /*@GetMapping(path = "{codeens}")
    public FicheENS getFicheActu(
        @PathVariable String codeens) {

        return ficheENSService.getFicheENS(codeens);
    }*/
}