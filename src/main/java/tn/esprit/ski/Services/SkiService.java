package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Skieur;

import java.util.List;

public interface SkiService {
    void add(Skieur s);
    Skieur update(Skieur s);
    List<Skieur> getAll();

    Skieur getById(Long id);
    void remove(long id);
}
