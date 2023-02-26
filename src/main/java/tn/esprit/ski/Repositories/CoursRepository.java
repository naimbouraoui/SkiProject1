package tn.esprit.ski.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Cours;

public interface CoursRepository extends CrudRepository<Cours,Long> {
}
