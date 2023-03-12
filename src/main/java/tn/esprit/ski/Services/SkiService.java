package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Abonnement;
import tn.esprit.ski.entities.Skieur;
import tn.esprit.ski.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

public interface SkiService {
    void add(Skieur s);
    Skieur update(Skieur s);
    List<Skieur> getAll();

    Skieur getById(Long id);
    void remove(long id);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    Skieur assignSkierToAbo(Long numSkieur, Long numAbon);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);

}
