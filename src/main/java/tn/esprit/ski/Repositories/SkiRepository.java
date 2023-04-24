package tn.esprit.ski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.ski.entities.Skieur;
import tn.esprit.ski.entities.TypeAbonnement;
import tn.esprit.ski.entities.TypeCours;

import java.util.List;

public interface SkiRepository extends CrudRepository<Skieur,Long> {
    List<Skieur> findByAbonnementsTypeAbon(TypeAbonnement typeAbonnement); //select * from Skieur

    List<Skieur> findByInscriptionsCoursTypeCours(TypeCours typeCours);

    //public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
   /* @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN abonnement a on " +
            "s.abonnement_num_abon = a.num_abon" +
            "WHERE a.type_abonnement = :typeabonnement  ", nativeQuery = true)
    public List<Skieur> retrieveSkiersBySubscriptionTypeSQL(@Param("typeabonnement") TypeAbonnement typeAbonnement);

    @Query(value = "SELECT s " +
            "FROM Skieur s " +
            "where s.abonnement.typeAbonnement = :typeabonnement ")
    public List<Skieur> retrieveSkiersBySubscriptionTypeJPQL(@Param("typeabonnement") TypeAbonnement typeAbonnement);

    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "ORDER BY (SELECT COUNT * FROM inscription i WHERE i.num_skieur = s.num_skieur)", nativeQuery = true)
    List<Skieur> OrderSkieurByNbrInscription();

    @Query(value = "SELECT n FROM Skieur n ORDER BY n.inscriptionList.size")
    List<Skieur> OrderSkieurByNbrInscriptionJPQL();

    /*@Query(value = "Select *\n" +
            "FROM skieur s \n" +
            "JOIN Inscription i ON i.numSkieur=s.numSkieur\n" +
            "JOIN cours c ON c.num_cours=i.num_cours\n" +
            "JOIN moniteur_cours mc ON c.num_moniteur=mc.moniteur_num_cours\n" +
            "JOIN moniteur m ON m.num_moniteur=mc.moniteur_num_moniteur" +
            "WHERE m.nomm= :nom", nativeQuery = true)
    public List<Skieur> ListeSkieurByCoursMoniteurSql(@Param("nom") String nom);*/

    /*@Query("select s from Skieur s" +
            " JOIN Inscription i " +
            "on i.Skieur.numSkieur = s.numSkieur" +
            "JOIN moniteur m" +
            "On i.cour member of m.cours where m.nomM= : nom")
    public List<Skieur> ListeSkieurByCoursMoniteurSql(@Param("nom") String nom);*/
}