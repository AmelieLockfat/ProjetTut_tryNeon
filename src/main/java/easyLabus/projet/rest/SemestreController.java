package easyLabus.projet.rest;

import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.SemestreSimple;
import easyLabus.projet.dto.UeSimple;
import easyLabus.projet.entity.Semestre;
import easyLabus.projet.requestedEntity.RequestedUESimple;
import easyLabus.projet.service.SemestreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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



    @PostMapping("AddUe")
    public void addUe(
        @RequestBody RequestedUESimple newUe,
        @RequestParam(required = true) Long idsemestre) {

        semestreservice.addNewUe(newUe.getCodeue(),newUe.getIntituleue(), idsemestre);
    }
}
