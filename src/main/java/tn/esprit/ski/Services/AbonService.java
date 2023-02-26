package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Abonnement;

import java.util.List;

public interface AbonService {
    void add(Abonnement a);
    Abonnement update(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getById(long id);
    void remove(long id);
}
