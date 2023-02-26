package tn.esprit.ski.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numAbo;
    LocalDate dateDebut;
    LocalDate DateFin;
    float prixAbon;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbon;
}
