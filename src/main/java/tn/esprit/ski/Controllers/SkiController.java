package tn.esprit.ski.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.SkiService;
import tn.esprit.ski.entities.Skieur;
import tn.esprit.ski.entities.TypeAbonnement;

import java.util.List;

@RestController
@RequestMapping("/skieur")
@RequiredArgsConstructor
public class SkiController {
    //@Autowired
    private final SkiService skiService;

    @PostMapping
    public void add(Skieur s) {
        skiService.add(s);
    }

    @PutMapping
    public Skieur update(Skieur s) {
        return skiService.update(s);
    }

    @GetMapping
    public List<Skieur> getAll() {
        return skiService.getAll();
    }

    @GetMapping("/{id}")
    public Skieur getById(@PathVariable Long id) {
        return skiService.getById(id);
    }

    @DeleteMapping
    public void remove(@PathVariable long id) {
        skiService.remove(id);
    }

    @PutMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        return skiService.assignSkierToPiste(numSkieur, numPiste);
    }

    @PutMapping("/{numSkieur}/{numAbon}")
    public Skieur assignSkierToAbo(@PathVariable Long numSkieur, @PathVariable Long numAbon) {
        return skiService.assignSkierToAbo(numSkieur, numAbon);
    }

    @GetMapping("/skAbon/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement) {
        return skiService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
