package easyLabus.projet.rest;

import easyLabus.projet.dto.EnseignementDTO;
import easyLabus.projet.entity.Enseignement;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import easyLabus.projet.service.EnseignementService;

@RestController
@RequestMapping(path = "/easyLabus/enseignement")
public class EnseignementController {
	private final EnseignementService enseignementService;
	private final ModelMapper mapper;
	// @Autowired
	public EnseignementController(EnseignementService enseignementService, ModelMapper mapper) {
		this.enseignementService = enseignementService;
		this.mapper = mapper;
	}

	@PostMapping("ajouter/{codeUE}")
	public EnseignementDTO ajouter(@PathVariable String codeUE) {
		Enseignement enseignement = enseignementService.gEnseignement(codeUE);
		return mapper.map(enseignement, EnseignementDTO.class);		 
	}
}