package tn.esprit.ski.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSkieur;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String Ville;
    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscriptions;
    @ManyToMany
    Set<Piste> pistes;
    @OneToOne
    Abonnement abonnements;
}
