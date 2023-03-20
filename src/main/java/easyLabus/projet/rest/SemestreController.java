package easyLabus.projet.rest;

import easyLabus.projet.entity.Semestre;
import easyLabus.projet.service.SemestreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/semestres")
public class SemestreController {
    private final SemestreService semestreservice;
    // @Autowired
    public SemestreController(SemestreService semestreservice) {
        this.semestreservice = semestreservice;
    }

    @GetMapping(path= "{intituleniveau}/getSemestre")
    public List<Semestre> getSemestre(@PathVariable String intituleniveau)
    {return semestreservice.getSemestrebyNiveau(intituleniveau);}


}
