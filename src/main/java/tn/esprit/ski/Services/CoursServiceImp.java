package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ski.Repositories.CoursRepository;
import tn.esprit.ski.entities.Cours;

import java.util.List;

@Service
public class CoursServiceImp implements CoursService{
     @Autowired
    private CoursRepository coursRepository;

     @Override
     public void add(Cours c){
         coursRepository.save(c);
     }
     @Override
     public Cours update(Cours c){
         return coursRepository.save(c);
     }
     @Override
    public List<Cours> getAll(){
         return (List<Cours>) coursRepository.findAll();
     }
     @Override
    public Cours getById(long id){
         return coursRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(long id){
         coursRepository.deleteById(id);
    }
}
