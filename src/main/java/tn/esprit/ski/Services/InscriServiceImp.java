package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ski.Repositories.InscriRepository;
import tn.esprit.ski.entities.Inscription;

import java.util.List;

@Service
public class InscriServiceImp implements InscriService{
    @Autowired
    private InscriRepository inscriRepository;

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
}
