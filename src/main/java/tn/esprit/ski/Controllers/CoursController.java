package tn.esprit.ski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.CoursService;
import tn.esprit.ski.entities.Cours;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private CoursService coursService;
    @PostMapping
    public void add(Cours c){
        coursService.add(c);
    }
    @PutMapping
    public Cours update(Cours c){
        return coursService.update(c);
    }
    @GetMapping
    public List<Cours> getAll(){
        return coursService.getAll();
    }
    @GetMapping("/{id}")
    public Cours getById(@PathVariable long id){
        return coursService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void remove(long id){
        coursService.remove(id);
    }

}
