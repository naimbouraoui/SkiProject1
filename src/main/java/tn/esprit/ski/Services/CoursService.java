package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Cours;
import tn.esprit.ski.entities.Moniteur;

import java.util.List;

public interface CoursService {
    void add(Cours c);
    Cours update(Cours c);
    List<Cours> getAll();
    Cours getById(long id);
    void remove(long id);

}

