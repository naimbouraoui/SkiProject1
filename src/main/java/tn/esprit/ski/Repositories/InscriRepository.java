package tn.esprit.ski.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ski.entities.Inscription;

public interface InscriRepository extends CrudRepository<Inscription,Long> {
}
