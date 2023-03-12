package tn.esprit.ski.Services;

import tn.esprit.ski.entities.Abonnement;
import tn.esprit.ski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonService {
    void add(Abonnement a);
    Abonnement update(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getById(long id);
    void remove(long id);
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbonnement);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
