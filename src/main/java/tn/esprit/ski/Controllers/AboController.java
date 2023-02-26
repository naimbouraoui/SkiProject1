package tn.esprit.ski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.AbonService;
import tn.esprit.ski.entities.Abonnement;

import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AboController {
    // http://localhost:9090/abonnement
    @Autowired
    private AbonService abonService;
    @PostMapping
    public void add(@RequestBody Abonnement a){
        abonService.add(a);
    }
    @PutMapping
    public Abonnement update(@RequestBody Abonnement a){
        return abonService.update(a);
    }
    @GetMapping
    public List<Abonnement> getAll(){
        return abonService.getAll();
    }
    @GetMapping("/{id}")
    public Abonnement getById(@PathVariable long id){
        return abonService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        abonService.remove(id);
    }

}
