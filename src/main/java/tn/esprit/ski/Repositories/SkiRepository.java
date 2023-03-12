package tn.esprit.ski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Skieur;
import tn.esprit.ski.entities.TypeAbonnement;
import tn.esprit.ski.entities.TypeCours;

import java.util.List;

public interface SkiRepository extends CrudRepository<Skieur,Long>{
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement); //select * from Skieur
    List<Skieur> findByInscriptionsCoursTypeCours(TypeCours typeCours);
}
