package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ski.Repositories.CoursRepository;
import tn.esprit.ski.Repositories.InscriRepository;
import tn.esprit.ski.Repositories.SkiRepository;
import tn.esprit.ski.entities.Cours;
import tn.esprit.ski.entities.Inscription;
import tn.esprit.ski.entities.Skieur;

import java.util.List;

@Service
public class InscriServiceImp implements InscriService{
    @Autowired
    private InscriRepository inscriRepository;
    @Autowired
    private SkiRepository skiRepository;
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public void add(Inscription i){
        inscriRepository.save(i);
    }
    @Override
    public Inscription update(Inscription i){
        return inscriRepository.save(i);
    }
    @Override
    public List<Inscription> getAll(){
        return (List<Inscription>) inscriRepository.findAll();
    }
    @Override
    public Inscription getById(long id){
        return inscriRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(long id){
        inscriRepository.deleteById(id);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
      //  Cours cours=CoursRepository.findById(numCours).orElse(null);
        //Assert.notNull(cours, "cours not found");
        //Skieur skieur=skiRepository.findById(numSkieur).orElse(null);
        //Assert.notNull(skieur,"skieur not found");
        //if(cours.getTypeCours().equals("(COLLECTIF_ENFANT")||cours.getTypeCours().equals"COLLECTIF_ADULTE"){
         //   if (cours.getInscriptions().size() < 6) {
          //      if(skieur.getDateNaissance().)
          //  }
       // }

    return null;
    }

}
