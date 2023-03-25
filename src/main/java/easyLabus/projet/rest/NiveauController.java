package easyLabus.projet.rest;

import java.util.List;

import easyLabus.projet.dto.NiveauSimple;
import easyLabus.projet.dto.ResponsableAnnee;
import easyLabus.projet.service.NiveauService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/niveaus")
public class NiveauController {
    private final NiveauService niveauService;
	// @Autowired
	public NiveauController(NiveauService niveauService) {
		this.niveauService = niveauService;
	}

    @GetMapping("All")
    public List<NiveauSimple> getAll () {
        return niveauService.getAll();
    }

    @GetMapping("Responsable")
    public ResponsableAnnee getResponsableAnnee(
        @RequestParam(required = true) String intitule) {

        return niveauService.getResponsable(intitule);
    }
}
