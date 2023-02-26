package tn.esprit.ski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.InscriService;
import tn.esprit.ski.entities.Inscription;

import java.util.List;

@RestController
@RequestMapping("/Inscription")
public class InscriController {
    @Autowired
    private InscriService inscriService;
    @PostMapping
    public void add(Inscription i){
        inscriService.add(i);
    }
    @PutMapping
    public Inscription update(Inscription i){
        return inscriService.update(i);
    }
    @GetMapping
    public List<Inscription> getAll(){
        return inscriService.getAll();
    }
    @GetMapping("/{id}")
    public Inscription getById(@PathVariable long id){
        return inscriService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        inscriService.remove(id);
    }

}
