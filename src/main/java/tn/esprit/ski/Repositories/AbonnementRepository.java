package tn.esprit.ski.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Abonnement;
import tn.esprit.ski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends CrudRepository<Abonnement,Long> {
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    Set<Abonnement> findByTypeAbonOrderByDateDebut(TypeAbonnement typeAbonnement);
    List<Abonnement> findByAAndDateDebutBetween(LocalDate startDate, LocalDate endDate);

}
