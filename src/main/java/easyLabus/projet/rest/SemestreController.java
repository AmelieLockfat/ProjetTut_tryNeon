package easyLabus.projet.rest;

import easyLabus.projet.dto.SemestreSimple;
import easyLabus.projet.entity.Semestre;
import easyLabus.projet.service.SemestreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/semestres")
public class SemestreController {
    private final SemestreService semestreservice;
    // @Autowired
    public SemestreController(SemestreService semestreservice) {
        this.semestreservice = semestreservice;
    }

    @GetMapping(path= "ByNiveau")
    public List<SemestreSimple> getSemestre(
        @RequestParam(required = true) String intituleniveau){
        
        return semestreservice.getSemestreByNiveau(intituleniveau);
    }
}
