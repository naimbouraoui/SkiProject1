package tn.esprit.ski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.SkiService;
import tn.esprit.ski.entities.Skieur;

import java.util.List;

@RestController
@RequestMapping("/skieur")
public class SkiController {
    @Autowired
    private SkiService skiService;
    @PostMapping
    public void add(Skieur s){
        skiService.add(s);
    }
    @PutMapping
    public Skieur update(Skieur s){
        return skiService.update(s);
    }
    @GetMapping
    public List<Skieur> getAll(){
        return skiService.getAll();
    }
    @GetMapping("/{id}")
    public Skieur getById(@PathVariable Long id){
        return skiService.getById(id);
    }
    @DeleteMapping
    public void remove(@PathVariable long id){
        skiService.remove(id);
    }
    @PutMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste){
        return skiService.assignSkierToPiste(numSkieur,numPiste);
    }
    @PutMapping("/{numSkieur}/{numAbon}")
    public Skieur assignSkierToAbo(@PathVariable Long numSkieur,@PathVariable Long numAbon){
        return skiService.assignSkierToAbo(numSkieur,numAbon);
    }
}
