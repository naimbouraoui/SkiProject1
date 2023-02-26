package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Moniteur;
import tn.esprit.ski.entities.Piste;

import java.util.List;

public interface PisteService {
    void add(Piste p);
    Piste update(Piste p);
    List<Piste> getAll();
    Piste getById(long id);
    void remove(long id);
}
