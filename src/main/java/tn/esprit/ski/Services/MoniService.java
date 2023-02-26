package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Moniteur;

import java.util.List;

public interface MoniService {
    void add(Moniteur m);
    Moniteur update(Moniteur m);
    List<Moniteur> getAll();
    Moniteur getById(long id);
    void remove(long id);
}
