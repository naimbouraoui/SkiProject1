package tn.esprit.ski.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSkieur;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String Ville;
    @OneToMany(mappedBy = "skieur")
    List<Inscription> inscriptions;
    @ManyToMany
    List<Piste> pistes;
    @OneToOne
    Abonnement abonnements;
}
