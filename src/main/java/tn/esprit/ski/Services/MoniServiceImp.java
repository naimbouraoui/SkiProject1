package tn.esprit.ski.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ski.Repositories.MoniteurRepository;
import tn.esprit.ski.entities.Cours;
import tn.esprit.ski.entities.Inscription;
import tn.esprit.ski.entities.Moniteur;
import tn.esprit.ski.entities.Support;

import javax.print.attribute.standard.MediaSize;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoniServiceImp implements MoniService {
    //@Autowired
    private final MoniteurRepository moniteurRepository;

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

    @Override
    public Map<Cours, List<Integer>> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        return getById(numInstructor)
                .getCours()
                .stream()
                .filter(cours -> cours.getSupport().equals(support))
                .map(cours -> cours.getInscriptions())
                .flatMap(Collection::stream)
                //.map(Inscription::getNumSemaine)
                //.collect(Collectors.toList());
                .collect(Collectors.groupingBy

                        (
                                Inscription::getCours,
                                Collectors.mapping(Inscription::getNumSemaine,Collectors.toList())
                        ));
    }
}
