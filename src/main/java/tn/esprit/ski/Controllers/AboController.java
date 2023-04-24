package tn.esprit.ski.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Services.AbonService;
import tn.esprit.ski.entities.Abonnement;
import tn.esprit.ski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/abonnement")
@RequiredArgsConstructor
public class AboController {
    // http://localhost:9090/abonnement
    //@Autowired
    private final AbonService abonService;
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
    @GetMapping("/{typeAbo}")
    public Set<Abonnement> findByTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return abonService.findByTypeAbon(typeAbonnement);}
    @GetMapping("/subord/{typeabon1}")
    public Set<Abonnement> getSubscriptionByType(@PathVariable TypeAbonnement typeAbonnement){
        return abonService.getSubscriptionByType(typeAbonnement);
    }
    @GetMapping({"/{startDate}/{endDate}"})
    public  List<Abonnement> retrieveSubscriptionsByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
        return abonService.retrieveSubscriptionsByDates(startDate,endDate);
    }

}
