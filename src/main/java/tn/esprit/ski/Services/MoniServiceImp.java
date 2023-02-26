package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ski.Repositories.MoniteurRepository;
import tn.esprit.ski.entities.Moniteur;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Service
public class MoniServiceImp implements MoniService {
    @Autowired
    private MoniteurRepository moniteurRepository;

    @Override
    public void add(Moniteur m){
        moniteurRepository.save(m);
    }
    @Override
    public Moniteur update(Moniteur m){
        return moniteurRepository.save(m);
    }
    @Override
    public List<Moniteur> getAll(){
        return (List<Moniteur>) moniteurRepository.findAll();
    }
    @Override
    public Moniteur getById(long id){
        return moniteurRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(long id){
        moniteurRepository.deleteById(id);
    }
}
