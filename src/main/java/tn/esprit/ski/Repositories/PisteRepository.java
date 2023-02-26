package tn.esprit.ski.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Piste;

public interface PisteRepository extends CrudRepository<Piste,Long> {
}
