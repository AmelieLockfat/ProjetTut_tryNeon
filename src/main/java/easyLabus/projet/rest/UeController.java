package easyLabus.projet.rest;

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
}
