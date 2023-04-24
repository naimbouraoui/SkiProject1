package tn.esprit.ski.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.MoniService;
import tn.esprit.ski.entities.Moniteur;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
@RequiredArgsConstructor
public class MoniteurController {
    //@Autowired
    private final MoniService moniService;
    @PostMapping
    public void add(Moniteur m){
        moniService.add(m);
    }
    @PutMapping
    public Moniteur update(Moniteur m){
        return moniService.update(m);
    }
    @GetMapping()
    public List<Moniteur> getAll(){
        return moniService.getAll();
    }
    @GetMapping("/{id}")
    public Moniteur getById(@PathVariable long id){
        return moniService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        moniService.remove(id);
    }
}
