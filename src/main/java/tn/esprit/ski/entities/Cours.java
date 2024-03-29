package tn.esprit.ski.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours;
    int niveau;
    @Enumerated(EnumType.STRING)
    Support support;
    float prix;
    int creneau;
    @OneToMany(mappedBy = "cours")
    List<Inscription> inscriptions;
}
