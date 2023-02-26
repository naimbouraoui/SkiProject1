package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Inscription;
import tn.esprit.ski.entities.Skieur;

import java.util.List;

public interface InscriService {
    void add(Inscription i);
    Inscription update(Inscription i);
    List<Inscription> getAll();

    Inscription getById(long id);
    void remove(long id);
}
