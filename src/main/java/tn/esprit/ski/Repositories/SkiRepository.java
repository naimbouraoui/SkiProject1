package tn.esprit.ski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Skieur;

public interface SkiRepository extends CrudRepository<Skieur,Long>{

}
