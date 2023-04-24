package tn.esprit.ski.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.PisteService;
import tn.esprit.ski.entities.Piste;

import java.util.List;

@RestController
@RequestMapping("/piste")
@RequiredArgsConstructor
public class PisteController {
    //@Autowired
    private final PisteService pisteService;
    @PostMapping
    public void add(Piste p){
        pisteService.add(p);
    }
    @PutMapping
    public Piste update(Piste p){
        return pisteService.update(p);
    }
    @GetMapping
    public List<Piste> getAll(){
        return pisteService.getAll();
    }
    @GetMapping("/{id}")
    public Piste getById(@PathVariable long id){
        return pisteService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        pisteService.remove(id);
    }
}
