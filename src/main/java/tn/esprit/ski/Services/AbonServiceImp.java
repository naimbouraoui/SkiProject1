package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ski.Repositories.AbonnementRepository;
import tn.esprit.ski.entities.Abonnement;

import java.util.List;

@Service
public class AbonServiceImp implements AbonService {
    @Autowired
    private AbonnementRepository abonnementRepository;

    @Override
    public void add(Abonnement a){
        abonnementRepository.save(a);
    }
    @Override
    public Abonnement update(Abonnement a){
        return abonnementRepository.save(a);
    }
    @Override
    public List<Abonnement> getAll(){
        return (List<Abonnement>) abonnementRepository.findAll();
    }
    @Override
    public Abonnement getById(long id){
        return abonnementRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(long id){
        abonnementRepository.deleteById(id);
    }

}
