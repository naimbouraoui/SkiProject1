package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Cours;
import tn.esprit.ski.entities.Moniteur;
import tn.esprit.ski.entities.Support;

import java.util.List;
import java.util.Map;

public interface MoniService {
    void add(Moniteur m);
    Moniteur update(Moniteur m);
    List<Moniteur> getAll();
    Moniteur getById(long id);
    void remove(long id);
    public Map<Cours,List<Integer>> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
